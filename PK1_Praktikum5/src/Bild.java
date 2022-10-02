import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Objects;

public class Bild extends Medium{

    private String ort;

    public Bild(String titel, int jahr,String ort,Medienverwaltung m){
        super(titel,jahr,m);
        this.ort = ort;
    }

    public String getOrt() {
        return ort;
    }

    @Override
    public void druckeDaten(OutputStream stream) {
        PrintWriter pw = new PrintWriter(stream);
        pw.printf("ID = %d \"%s\" aufgenommen im Jahr %d in %s%n",this.getId(),this.getTitel(),this.getJahr(),this.getOrt());
        pw.flush();
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
