public class Vorstand extends Manager{

    private double abfindung;

    public Vorstand(String n, double m, double b, double a)
    {
        super(n,m,b);
        abfindung=a;
    }

    public void setAbfindung(double abfindung) {
        this.abfindung = abfindung;
    }

    public double getAbfindung() {
        return abfindung;
    }

    @Override
    public double getMonatsgehalt() {
        return super.getMonatsgehalt() + abfindung;
    }
}
