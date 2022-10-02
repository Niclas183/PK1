import java.util.Collection;
import java.util.LinkedList;

public class PrimeWorker implements Runnable{

    int number;
    Collection<Integer> c;

    public PrimeWorker(int number, Collection<Integer> c)
    {
        this.number=number;
        this.c=c;
    }

    @Override
    public void run()
    {
        if(Prime.isPrime(number))
            c.add(number);
    }

}
