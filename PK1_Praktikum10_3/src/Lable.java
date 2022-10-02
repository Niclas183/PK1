public class Lable {

    private String type;
    private int bestBefore;
    private Bottle b;

    public Lable(String type, int bb, Bottle b)
    {
        this.type=type;
        bestBefore=bb;
        this.b=b;
    }

    public int getBestBefore() {
        return bestBefore;
    }

    public String getType() {
        return type;
    }
}
