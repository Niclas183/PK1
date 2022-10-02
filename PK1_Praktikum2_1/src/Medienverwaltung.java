public class Medienverwaltung {

    private Medium[] medien = new Medium[1000];
    private int anzMedien = 0;

    public Medienverwaltung(){}

    public void aufnehmen(Medium m)
    {
        if(anzMedien<1000)
            medien[anzMedien++] = m;
        else
            System.out.println("Medienverwaltung voll!");
    }

    public void zeigeMedien()
    {
        for(int i = 0; i<anzMedien; i++)
            medien[i].druckeDaten();
    }

    public void sucheNeuesMedium()
    {
        if(anzMedien>0)
        {
            int temp = 0;
            for(int i = 1; i<anzMedien; i++)
            {
                if(medien[i].alter()<medien[temp].alter())
                    temp=i;
            }
            medien[temp].druckeDaten();
        }
        else
            System.out.println("Kein Medium in Medienverwaltung!");
    }

    public double berechneErscheinungsjahr()
    {
        if(anzMedien==0)
            return 0;
        double erg = 0;
        for(int i = 0; i<anzMedien; i++)
            erg+=medien[i].getJahr();
        return erg/anzMedien;
    }

}
