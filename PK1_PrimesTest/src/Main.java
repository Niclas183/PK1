import java.util.Collection;
import java.util.LinkedList;
import java.util.function.BinaryOperator;

public class Main {

    

    public static int sum(Collection<Integer> liste)
    {
        return liste.stream().reduce(0,(a,b)->(a+b));
    }

    public static int sum2(Collection<Integer> liste)
    {
        return liste.stream().reduce(0, new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer+integer2;
            }
        });
    }

    public static Collection<Integer> filterPrimes(Collection<Integer> zahlen)
    {
        Collection<Integer> erg = new LinkedList<Integer>();
        Thread[] t = new Thread[zahlen.size()];
        int i = 0;
        for(Integer zahl: zahlen)
        {
            t[i]=new Thread(new PrimeWorker(zahl,erg));
            t[i++].start();
        }
        try{
            for(Thread thread: t)
                thread.join();
        }
        catch(InterruptedException e)
        {
            //Todo
        }
        return erg;
    }


    public static void main(String[] args) {
        LinkedList<Integer> test = new LinkedList<>();
        for(int i = 3; i<100000; i++)
        {
            test.add(i);
        }
        Collection<Integer> filter = filterPrimes(test);
        for(Integer i: filter)
        {
            System.out.println(i);
        }
    }

}
