public class Manager extends Angestellter{

    private double bonus;

    public Manager(String n, double m, double b)
    {
        super(n,m);
        bonus=b;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public double berechneJahresgehalt() {
        return super.berechneJahresgehalt() + bonus;
    }
}
