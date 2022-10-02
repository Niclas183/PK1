public class Bottle {

    private Lable l;

    public Bottle(){

    }

    public void printLable()
    {
        System.out.printf("%s mindestens haltbar bis %d\n",l.getType(),l.getBestBefore());
    }

    public void lable(Lable l)
    {
        this.l=l;
    }

}
