import javax.swing.*;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {


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
        System.out.println("Medienverwaltung");
        System.out.println();
        System.out.println("1. Audio aufnehmen");
        System.out.println("2. Bild aufnehmen");
        System.out.println("3. Zeige alle Medien");
        System.out.println("4. Zeige neues Medium");
        System.out.println("5. Berechne durchschnittliches Erscheinungsjahr");
        System.out.println("6. Beenden");
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
                case 3: m.zeigeMedien(); break;
                case 4: m.sucheNeuesMedium(); break;
                case 5: System.out.printf("Durchschnittliches Erscheinungsjahr: %.2f%n",m.berechneErscheinungsjahr()); break;
                case 6: break;
                default: System.out.println("Ungültige Eingabe!");
            }
        }while(auswahl!=6);
    }

}
