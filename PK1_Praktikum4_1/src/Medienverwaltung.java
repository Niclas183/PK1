import java.util.*;

public class Medienverwaltung {

    private List<Medium> medien;


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
        Collections.sort(medien);
        for(Medium m : medien){
            m.druckeDaten();
        }
    }

    public void sucheNeuesMedium()
    {
        Iterator<Medium> iterator = medien.iterator();
        if(iterator.hasNext())
        {
            Medium neueste = iterator.next();
            while(iterator.hasNext())
            {
                Medium m = iterator.next();
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
        Iterator<Medium> iterator = medien.iterator();
        if(!iterator.hasNext())
            return 0;
        double erg = 0;
        while(iterator.hasNext())
        {
            erg+=iterator.next().getJahr();
        }
        return erg/medien.size();
    }

}
