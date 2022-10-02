import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> l = new LinkedList<Integer>();

        Runnable producer = new Producer(l,5,1,300);
        Runnable producer2 = new Producer(l,5,2,100);
        Runnable consumer = new Consumer(l,1,100);

        Thread a = new Thread(producer);
        Thread b = new Thread(consumer);
        Thread c = new Thread(producer2);

        a.start();
        b.start();
        c.start();

    }

}
