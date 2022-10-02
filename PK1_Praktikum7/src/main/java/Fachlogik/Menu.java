package Fachlogik;

import javax.swing.*;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {


    public static FileOutputStream getFile() throws EmptyFilenameException
    {
        boolean correct = false;
        FileOutputStream fos = null;
        while(!correct) {
            String datei = JOptionPane.showInputDialog(null, "Bitte Dateispeicherort eingeben:");
            if(datei==null)
                return null;
            else if(datei.isEmpty())
                throw new EmptyFilenameException();
            try{
                fos = new FileOutputStream(datei);
                correct = true;
            }
            catch(IOException e){
                System.out.println("Bitte gültigen Dateispeicherort eingeben!");
            }
        }
        return fos;
    }

    public static FileInputStream getFileInput() throws EmptyFilenameException
    {
        boolean correct = false;
        FileInputStream fis = null;
        while(!correct) {
            String datei = JOptionPane.showInputDialog(null, "Bitte Dateispeicherort eingeben:");
            if(datei==null)
                return null;
            else if(datei.isEmpty())
                throw new EmptyFilenameException();
            try{
                fis = new FileInputStream(datei);
                correct = true;
            }
            catch(IOException e){
                System.out.println("Bitte gültigen Dateispeicherort eingeben!");
            }
        }
        return fis;
    }

    public static void audioAufnehmen(Medienverwaltung m)
    {
        String titel = JOptionPane.showInputDialog(null,"Bitte Titel eingeben:");
        if(titel==null)
            return;
        String interpret = JOptionPane.showInputDialog(null,"Bitte Interpret eingeben:");
        if(interpret==null)
            return;
        int jahr = 0;
        boolean correct = false;
        while(!correct) {
            String StringJahr = JOptionPane.showInputDialog(null,"Bitte Erscheinungsjahr eingeben:");
            try {
                jahr = Integer.parseInt(StringJahr);
                correct = true;
            } catch (NumberFormatException e) {
                if(StringJahr==null)
                    return;
                JOptionPane.showMessageDialog(null, "Bitte gültiges Erscheinungsjahr eingeben!");
            }
        }
        int dauer = 0;
        correct = false;
        while(!correct) {
            String StringDauer = JOptionPane.showInputDialog(null,"Bitte Spieldauer in Sekunden eingeben:");
            try {
                dauer = Integer.parseInt(StringDauer);
                correct = true;
            } catch (NumberFormatException e) {
                if(StringDauer==null)
                    return;
                JOptionPane.showMessageDialog(null, "Bitte gültige Dauer eingeben!");
            }
        }
        m.aufnehmen(new Audio(titel,jahr,interpret,dauer,m));
    }

    public static void bildAufnehmen(Medienverwaltung m)
    {
        String titel = JOptionPane.showInputDialog(null,"Bitte Titel eingeben:");
        if(titel==null)
            return;
        String ort = JOptionPane.showInputDialog(null,"Bitte Ort eingeben:");
        if(ort==null)
            return;
        int jahr = 0;
        boolean correct = false;
        while(!correct) {
            String StringDauer = JOptionPane.showInputDialog(null,"Bitte Spieldauer in Sekunden eingeben:");
            try {
                jahr = Integer.parseInt(StringDauer);
                correct = true;
            } catch (NumberFormatException e) {
                if(StringDauer==null)
                    return;
                JOptionPane.showMessageDialog(null, "Bitte gültige Dauer eingeben!");
            }
        }
        m.aufnehmen(new Bild(titel,jahr,ort,m));
    }

    public static void printMenu()
    {
        System.out.println("Fachlogik.Medienverwaltung");
        System.out.println();
        System.out.println("1. Fachlogik.Audio aufnehmen");
        System.out.println("2. Fachlogik.Bild aufnehmen");
        System.out.println("3. Zeige alle Medien");
        System.out.println("4. Medienliste in Datei schreiben");
        System.out.println("5. Zeige neues Fachlogik.Medium");
        System.out.println("6. Berechne durchschnittliches Erscheinungsjahr");
        System.out.println("7. Medienliste speichern");
        System.out.println("8. Medienliste laden");
        System.out.println("9. Beenden");
    }

    public static void main(String[] args) {
        Medienverwaltung m = new Medienverwaltung();
        int auswahl;
        do{
            Scanner sc = new Scanner(System.in);
            printMenu();
            try {
                auswahl = sc.nextInt();
            }
            catch (InputMismatchException e)
            {
                auswahl = 0;
            }
            switch(auswahl)
            {
                case 1: audioAufnehmen(m); break;
                case 2: bildAufnehmen(m); break;
                case 3: m.zeigeMedien(System.out); break;
                case 4:{
                    boolean again = true;
                    FileOutputStream fos = null;
                    while(again) {
                        try {
                            fos = getFile();
                            again = false;
                        } catch (EmptyFilenameException e) {
                            int input = JOptionPane.showConfirmDialog(null, "Dateiname ist leer! Neuen Dateinamen wählen?", "Hinweis", JOptionPane.YES_NO_OPTION);
                            if (input != JOptionPane.YES_OPTION)
                                again = false;
                        }
                    }
                    if(fos!=null) {
                        m.zeigeMedien(fos);
                        try{
                            fos.close();
                        }
                        catch(IOException e)
                        {
                            e.printStackTrace();
                        }
                    }}
                    break;
                case 5: m.sucheNeuesMedium(System.out); break;
                case 6: System.out.printf("Durchschnittliches Erscheinungsjahr: %.2f%n",m.berechneErscheinungsjahr()); break;
                case 7:{
                    boolean again = true;
                    FileOutputStream fos = null;
                    while(again) {
                        try {
                            fos = getFile();
                            again = false;
                        } catch (EmptyFilenameException e) {
                            int input = JOptionPane.showConfirmDialog(null, "Dateiname ist leer! Neuen Dateinamen wählen?", "Hinweis", JOptionPane.YES_NO_OPTION);
                            if (input != JOptionPane.YES_OPTION)
                                again = false;
                        }
                    }
                    if(fos!=null) {
                        try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                            oos.writeObject(m);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        finally{
                            try {
                                fos.close();
                            }
                            catch(IOException e)
                            {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                    break;
                case 8: {
                    boolean again = true;
                    FileInputStream fis = null;
                    while(again) {
                        try {
                            fis = getFileInput();
                            again = false;
                        } catch (EmptyFilenameException e) {
                            int input = JOptionPane.showConfirmDialog(null, "Dateiname ist leer! Neuen Dateinamen wählen?", "Hinweis", JOptionPane.YES_NO_OPTION);
                            if (input != JOptionPane.YES_OPTION)
                                again = false;
                        }
                    }
                    if(fis!=null) {
                        try(ObjectInputStream ois = new ObjectInputStream(fis))
                        {
                            m = (Medienverwaltung) ois.readObject();
                            Medium.setNumM(m.getAnzMedien());
                        }
                        catch(IOException e)
                        {
                            e.printStackTrace();
                        }
                        catch(ClassNotFoundException e)
                        {
                            System.out.println("Class Datei nicht gefunden oder ungültige Class Datei!");
                        }
                        finally{
                            try {
                                fis.close();
                            }
                            catch(IOException e)
                            {
                                e.printStackTrace();
                            }
                        }
                    }}
                break;
                case 9: break;
                default: System.out.println("Ungültige Eingabe!");
            }
        }while(auswahl!=9);
    }

}
