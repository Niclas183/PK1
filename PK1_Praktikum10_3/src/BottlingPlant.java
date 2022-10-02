public class BottlingPlant implements Runnable{

    private Conveyor c;
    private int speed;


    public BottlingPlant(Conveyor c, int speed)
    {
        this.c=c;
        this.speed=speed;
    }

    @Override
    public void run() {
        while(!Thread.interrupted()) {
            try {
                synchronized (c) {
                    while (c.isOverloaded()) {
                        System.out.println("Abfuellanlage: Warten, da Foerderband voll");
                        c.wait();
                    }
                    c.load(new Bottle());
                    System.out.println("Abfuellanlage: Neue Flasche abgefuellt");
                    c.notifyAll();
                }
                Thread.sleep(speed);
            } catch (InterruptedException e) {

            }
        }
    }
}
