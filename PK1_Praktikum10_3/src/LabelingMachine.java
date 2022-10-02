import java.time.Year;

public class LabelingMachine implements Runnable {

    private Conveyor c;
    private int speed;
    private String type;

    public LabelingMachine(Conveyor c, int speed, String type) {
        this.c = c;
        this.speed = speed;
        this.type = type;
    }

    @Override
    public void run() {

        while (!Thread.interrupted()) {
            try {
                synchronized (c) {
                    while (c.isEmpty()) {
                        System.out.println("Etikettiermaschine: Warten, da Foerderband leer.");
                        c.wait();
                    }
                    Bottle b = c.withdraw();
                    b.lable(new Lable(type, Year.now().getValue() + 1, b));
                    b.printLable();
                    c.notifyAll();
                }
                Thread.sleep(speed);
            } catch (InterruptedException e) {

            }
        }
    }
}
