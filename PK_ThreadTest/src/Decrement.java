public class Decrement implements Runnable{

    int[] a;


    public Decrement(int[] a)
    {
        this.a=a;
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (a) {
                    while (a[0] <= 1) {
                        a.notifyAll();
                        a.wait();
                    }
                    a[0]--;
                    System.out.println(a[0]);
                }
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
