public class Main {

    public static void main(String[] args) {
        Fuhrpark f = new Fuhrpark();
        f.add(new Auto(100,"Audi"));
        f.add(new Auto(100,"Audi"));
        f.add(new Auto(100,"Audi"));
        f.add(new Auto(100,"BMW"));
        System.out.println(f.istHerstellerVorhanden("Audi"));
        System.out.println(f.neuetesBaujahr("Audi").getBaujahr());
        f.druckeAutosMitBaujahr(100,6);
    }



}
