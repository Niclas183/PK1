import java.util.Objects;

public class Audio extends Medium{

    private String interpret;
    private int dauer;

    public Audio(String titel, int jahr,String interpret,int dauer){
        super(titel,jahr);
        this.interpret = interpret;
        this.dauer = dauer;
    }

    public int getDauer() {
        return dauer;
    }

    public String getInterpret() {
        return interpret;
    }

    @Override
    public boolean equals(Object o) {
        if(!super.equals(o)) return false;
        Audio a = (Audio) o;
        return (dauer == a.getDauer() && interpret.equals(a.getInterpret()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitel(), getJahr(), interpret, dauer);
    }

    @Override
    public void druckeDaten() {
        System.out.println("ID = " + this.getId() + " \"" + this.getTitel() + "\" von " + interpret + " aus " + this.getJahr()
                + " Spieldauer: " + dauer + " sek.");
    }
}
