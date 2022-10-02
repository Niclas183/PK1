import java.util.Comparator;

public class NameVergleicher implements Comparator<Angestellter> {

    @Override
    public int compare(Angestellter o1, Angestellter o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
