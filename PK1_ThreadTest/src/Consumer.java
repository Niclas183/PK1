import java.util.List;

public class Consumer implements Runnable{

    private List<Integer> l;
    private int num;
    private int time;

    public Consumer(List<Integer> l, int num, int time)
    {
        this.l=l;
        this.num = num;
        this.time = time;
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (l) {
                    while (l.isEmpty()) {
                        System.out.printf("Stapel leer Consumer %d wartet!\n", num);
                        l.wait();
                    }
                    int i = l.remove(0);
                    System.out.printf("Consumer %d hat %d entfernt\n", num, i);
                    l.notifyAll();
                }
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
