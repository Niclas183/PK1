package Fachlogik;

import Datenhaltung.IDao;
import Datenhaltung.PersistenzException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.*;

public class Medienverwaltung implements Serializable {

    private List<Medium> medien;
    static final long serialVersionUID = -7205887901549211786L;

    public void writeInFile(String s) throws IOException
    {
        try(FileWriter fw = new FileWriter(s))
        {
            for(Medium medium: medien)
            {
                fw.write(medium.toString());
            }
        }
        catch(IOException e)
        {
            throw e;
        }
    }

    public void laden(IDao i) throws PersistenzException
    {
        try {
            this.medien = i.laden();
            Medium.setNumM(getAnzMedien());
        }
        catch(PersistenzException e) {
            throw e;
        }
    }

    public void loescheLetztesMedium()
    {
        if(medien.size()>0) {
            medien.remove(medien.size() - 1);
            Medium.setNumM(Medium.getNumM() - 1);
        }
    }

    public void speichern(IDao i) throws PersistenzException
    {
        try {
            i.speichern(medien);
        }
        catch(PersistenzException e)
        {
            throw e;
        }
    }

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

    public Bild addBild()
    {
        Bild b = new Bild("",0,"",this);
        aufnehmen(b);
        return b;
    }

    public Audio addAudio()
    {
        Audio a = new Audio("",0,"",0,this);
        aufnehmen(a);
        return a;
    }

    public void zeigeMedien(OutputStream stream)
    {
        Collections.sort(medien);
        for(Medium m : medien){
            m.druckeDaten(stream);
        }
    }

    public Medium sucheNeuesMedium()
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
            return neueste;
        }
        else
            return null;
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

    public Iterator<Medium> iterator()
    {
        return medien.iterator();
    }

}
