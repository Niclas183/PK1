package Fachlogik;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Objects;

public class Audio extends Medium{

    static final long serialVersionUID = 3118273267415809774L;
    private String interpret;
    private int dauer;

    public Audio()
    {
        super("",0,null);
        interpret = "";
    }

    public Audio(String titel, int jahr,String interpret,int dauer,Medienverwaltung m){
        super(titel,jahr,m);
        this.interpret = interpret;
        this.dauer = dauer;
    }

    public void setDauer(int dauer) {
        this.dauer = dauer;
    }

    public int getDauer() {
        return dauer;
    }

    public String getInterpret() {
        return interpret;
    }

    public void setInterpret(String interpret) {
        this.interpret = interpret;
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
    public void druckeDaten(OutputStream stream) {
        PrintWriter pw = new PrintWriter(stream);
        pw.printf("ID = %d \"%s\" von %s aus %d Spieldauer: %d sek.%n",this.getId(),this.getTitel(),this.getInterpret(),this.getJahr(),this.getDauer());
        pw.flush();
    }

    @Override
    public String toString()
    {
        return String.format("ID = %d \"%s\" von %s aus %d Spieldauer: %d sek.%n",this.getId(),this.getTitel(),this.getInterpret(),this.getJahr(),this.getDauer());
    }

}
