public class Main {

    public static void startTest(Runnable r) throws InterruptedException {
        Thread t1 = new Thread(r);
        t1.start();
        t1.join();
    }

    public static void main(String[] args) {

        int[] a = new int[1];
        Thread t1 = new Thread(new Increment(a));
        Thread t2 = new Thread(new Decrement(a));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
