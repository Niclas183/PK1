import java.io.Serializable;

public class Angestellter implements Comparable<Angestellter>, Serializable {

    private String name;
    private double monatsgehalt;

    public Angestellter(String n, double m)
    {
        name=n;
        monatsgehalt=m;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMonatsgehalt(double monatsgehalt) {
        this.monatsgehalt = monatsgehalt;
    }

    public String getName() {
        return name;
    }

    public double getMonatsgehalt() {
        return monatsgehalt;
    }

    public double berechneJahresgehalt()
    {
        return monatsgehalt*12;
    }

    @Override
    public int compareTo(Angestellter o) {
        return Double.compare(berechneJahresgehalt(),o.berechneJahresgehalt());
    }

}
