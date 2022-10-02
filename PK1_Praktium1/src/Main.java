public class Main {

    public static void main(String[] args) {
        Audio a = new Audio("Test Lied", 2005, "test",250);
        Bild b = new Bild("Starry Night",1337,"Selm");
        Audio c = new Audio("Test Lied", 2005, "test",250);
        Audio d = new Audio("Test Lied", 2005, "test",42);

        a.druckeDaten();
        b.druckeDaten();
        c.druckeDaten();
        d.druckeDaten();
        System.out.println(a.getTitel() + " ist " + a.alter() + " Jahre alt!");
        System.out.println(a.equals(c));
        System.out.println(a.equals(b));
        System.out.println(a.equals(d));
        System.out.println(a.hashCode());
        System.out.println(c.hashCode());
        System.out.println(d.hashCode());
        System.out.println(a.getClass());
    }

}
