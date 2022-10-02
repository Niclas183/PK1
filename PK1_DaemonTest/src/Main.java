public class Main {

    public static void main(String[] args) {

        Thread t = new Thread(()->{
            try{
                Thread.sleep(5000);
                System.out.println("Test");
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        });
        t.setDaemon(true);
        t.start();
        try {
            t.join();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


}
