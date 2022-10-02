import javax.naming.Name;
import java.io.*;
import java.rmi.server.ExportException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void schreiben (Angestellter a, File f)
    {
        UpperCaseWriter ucw = null;
        PrintWriter pw = null;
        FileWriter fw = null;
        try{
            fw = new FileWriter(f);
            ucw = new UpperCaseWriter(fw);
            pw = new PrintWriter(ucw);
            pw.printf("Name: %s%nGehalt: %.2f",a.getName(),a.getMonatsgehalt());
            pw.flush();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    public static void sortiereNamen(List<Angestellter> l)
    {
        Collections.sort(l,new NameVergleicher());
    }

    public static void sortiereGehalt(List<Angestellter> l)
    {
        Collections.sort(l);
    }

    public static void main(String[] args) {

        Angestellter a = new Angestellter("Max Angestellter", 3000);
        Manager m = new Manager("Max Manager", 4000, 300000);
        Vorstand v = new Vorstand("Max Vorstand", 10000,1000,3000);
        List<Angestellter> liste = new LinkedList<Angestellter>();
        liste.add(a);
        liste.add(m);
        liste.add(v);
        System.out.println("Sortiert nach Gehalt:");
        sortiereGehalt(liste);
        for(Angestellter angestellter : liste)
        {
            System.out.println(angestellter.getName() + "\t" + angestellter.berechneJahresgehalt());
        }
        System.out.println("Sortiert nach Namen:");
        sortiereNamen(liste);
        for(Angestellter angestellter : liste)
        {
            System.out.println(angestellter.getName() + "\t" + angestellter.berechneJahresgehalt());
        }
        schreiben(a,new File("C:\\temp\\test"));
        try(FileOutputStream fos = new FileOutputStream("c:\\temp\\test"); ObjectOutputStream os = new ObjectOutputStream(fos)){
            for(Angestellter ang: liste)
            {
                os.writeObject(ang);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        List<Angestellter> inputTest = new LinkedList<Angestellter>();
        try(FileInputStream fis = new FileInputStream("c:\\temp\\test"); ObjectInputStream os = new ObjectInputStream(fis)){
            while(true) {
                Angestellter ang = (Angestellter) os.readObject();
                inputTest.add(ang);
            }
        }
        catch(EOFException e)
        {
            //Ende der Datei erreicht; nichts machen
        }
        catch(IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        System.out.println("Input Liste Test:");
        for(Angestellter angestellter : inputTest)
        {
            System.out.println(angestellter.getName() + "\t" + angestellter.berechneJahresgehalt());
        }
    }

}
