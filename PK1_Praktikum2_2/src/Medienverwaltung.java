import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Medienverwaltung {

    private Collection medien;

    public Medienverwaltung()
    {
        medien = new ArrayList<>();
    }

    public void aufnehmen(Medium m)
    {
        medien.add(m);
    }

    public void zeigeMedien()
    {
        for(Object o : medien){
            ((Medium) o).druckeDaten();
        }

    }

    public void sucheNeuesMedium()
    {
        Iterator iterator = medien.iterator();
        if(iterator.hasNext())
        {
            Medium neueste = (Medium)iterator.next();
            while(iterator.hasNext())
            {
                Medium m = (Medium)iterator.next();
                if(m.alter()<neueste.alter())
                    neueste=m;
            }
            neueste.druckeDaten();
        }
        else
            System.out.println("Medienverwaltung ist leer!");
    }

    public double berechneErscheinungsjahr()
    {
        Iterator iterator = medien.iterator();
        if(!iterator.hasNext())
            return 0;
        double erg = 0;
        while(iterator.hasNext())
        {
            Medium m = (Medium)iterator.next();
            erg+=m.getJahr();
        }
        return erg/medien.size();
    }

}
