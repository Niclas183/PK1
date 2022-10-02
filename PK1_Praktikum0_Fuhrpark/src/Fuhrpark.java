import java.util.LinkedList;
import java.util.List;

public class Fuhrpark {

    List<Auto> garage;

    public Fuhrpark()
    {
        garage=new LinkedList<>();
    }

    public void add(Auto a)
    {
        garage.add(a);
    }

    public boolean istHerstellerVorhanden(String hersteller)
    {
        return garage.stream().map(a->a.getHersteller()).anyMatch(s->s.equals(hersteller));
    }

    public Auto neuetesBaujahr(String hersteller)
    {
        return garage.stream().filter(a->a.getHersteller().equals(hersteller)).max((a,b) -> Integer.compare(a.getBaujahr(),b.getBaujahr())).get();
    }

    public void druckeAutosMitBaujahr(int baujahr, int n)
    {
        garage.stream().filter(a->a.getBaujahr()==baujahr).limit(n).forEach(System.out::println);
    }

}
