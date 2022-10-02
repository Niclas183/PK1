import java.util.Objects;

public class Bild extends Medium{

    private String ort;

    public Bild(String titel, int jahr,String ort){
        super(titel,jahr);
        this.ort = ort;
    }

    public String getOrt() {
        return ort;
    }

    @Override
    public void druckeDaten() {
        System.out.println("ID = " + getId() + " \"" + getTitel() + "\" aufgenommen im Jahr " + getJahr() + " in " + ort);
    }

    @Override
    public boolean equals(Object o) {
        if(!super.equals(o)) return false;
        Bild b = (Bild) o;
        return ort.equals(b.getOrt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitel(), getJahr(), ort);
    }

}
