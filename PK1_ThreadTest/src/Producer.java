import java.util.List;

public class Producer implements Runnable{

    private List<Integer> l;
    private int max;
    private int num;
    private int time;

    public Producer(List<Integer> l, int max, int num, int time)
    {
        this.l=l;
        this.max=max;
        this.num=num;
        this.time=time;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                synchronized (l) {
                    while (l.size() >= max) {
                        System.out.printf("Stapel voll Producer %d wartet!\n", num);
                        l.wait();
                    }
                    l.add(i);
                    System.out.printf("Producer %d hat %d hinzugefügt\n", num, i);
                    l.notifyAll();
                }
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
