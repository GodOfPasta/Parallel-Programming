import java.util.concurrent.CyclicBarrier;
public class Car implements Runnable{
    private int carNumber;
    private CyclicBarrier startRace;
    public Car(int carNumber, CyclicBarrier go){
        this.carNumber = carNumber;
        this.startRace = go;
    }

    public void run() {
        try{
            System.out.println("Машина №" + carNumber + "подъехала к реке");
            startRace.await();
            System.out.println("Машина №" + carNumber + "продолжила движение!");
        } catch (Exception e) {}
    }
}
