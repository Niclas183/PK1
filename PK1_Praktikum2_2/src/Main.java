public class Main {

    public static void main(String[] args) {

        Medienverwaltung m = new Medienverwaltung();
        m.aufnehmen(new Audio("test",2009,"test",200,m));
        m.aufnehmen(new Bild("test2",2012,"test",m));
        m.aufnehmen(new Audio("test3",2015,"test",200,m));
        m.zeigeMedien();
        System.out.println(m.berechneErscheinungsjahr());
        m.sucheNeuesMedium();

    }

}
