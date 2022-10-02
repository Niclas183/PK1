package pk1.pk1_praktikum10_2;

public class Timer implements Runnable {

    private TimerListener t;

    public Timer(TimerListener t) {
        this.t = t;
    }

    @Override
    public void run() {
        try {
            while (true) {
                t.signalPerformed();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Timer gestoppt!");
        }
    }
}
