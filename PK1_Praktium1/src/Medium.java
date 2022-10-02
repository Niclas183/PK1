import java.util.Objects;

public abstract class Medium {

    private static int numM = 0;
    private final int id;
    private String titel;
    private int jahr;

    public Medium(String titel, int jahr)
    {
        this.titel = titel;
        this.jahr = jahr;
        this.id = numM++;
    }

    public int getId() {
        return id;
    }

    public int getJahr() {
        return jahr;
    }

    public String getTitel() {
        return titel;
    }

    public int alter()
    {
        return java.time.LocalDate.now().getYear()-jahr;
    }


    public abstract void druckeDaten();

    @Override
    public boolean equals(Object o) {
        if(this==o) return true;
        if(o==null) return false;
        if(getClass() != o.getClass()) return false;
        Medium m = (Medium) o;
        return(m.getJahr()==this.jahr && m.getTitel().equals(this.titel));
    }

    @Override
    public int hashCode() {
        return Objects.hash(titel, jahr);
    }
}
