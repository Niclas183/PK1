import java.util.LinkedList;
import java.util.List;

public class Conveyor {

    private List<Bottle> bottles = new LinkedList<Bottle>();
    private int maxBottles = 50;

    public void load(Bottle b) {
        if(!isOverloaded())
            bottles.add(b);
    }

    public Bottle withdraw()
    {
        if(!isEmpty())
            return bottles.remove(0);
        return null;
    }

    public boolean isEmpty()
    {
        return bottles.isEmpty();
    }

    public boolean isOverloaded()
    {
        return bottles.size()==maxBottles;
    }


}
