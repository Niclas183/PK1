package Fachlogik;

import java.io.OutputStream;
import java.io.Serializable;
import java.util.*;

public class Medienverwaltung implements Serializable {

    private List<Medium> medien;
    static final long serialVersionUID = -7205887901549211786L;

    public Medienverwaltung()
    {
        medien = new ArrayList<>();
    }

    public int getAnzMedien()
    {
        return medien.size();
    }

    public void aufnehmen(Medium m)
    {
        medien.add(m);
    }

    public void zeigeMedien(OutputStream stream)
    {
        Collections.sort(medien);
        for(Medium m : medien){
            m.druckeDaten(stream);
        }
    }

    public void sucheNeuesMedium(OutputStream stream)
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
            neueste.druckeDaten(stream);
        }
        else
            System.out.println("Fachlogik.Medienverwaltung ist leer!");
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
