public class Main {

    public static void main(String[] args) {
        Conveyor c = new Conveyor();
        LabelingMachine l1 = new LabelingMachine(c,500,"Bier");
        LabelingMachine l2 = new LabelingMachine(c,500,"Cola");
        BottlingPlant b1 = new BottlingPlant(c,300);

        Thread t1 = new Thread(l1);
        Thread t2 = new Thread(b1);
        Thread t3 = new Thread(l2);

        t1.start();
        t2.start();
        t3.start();
    }

}
