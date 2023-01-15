import java.util.concurrent.CountDownLatch;
public class Car implements Runnable {
    private int carNumber;
    CountDownLatch latch, arrive;   // Из main передается два latch`а
    public Car(int carNumber, CountDownLatch latch, CountDownLatch arrive) {
        this.carNumber = carNumber;
        this.latch = latch;
        this.arrive = arrive;
    }

    public synchronized void run() {
        try {
            System.out.printf("Автомобиль №%d подъехал к паромной переправе.\n", carNumber);    // - Машина подъезжает к переправе
            latch.countDown();                                                                  // - Машина уменьшает latch
            arrive.await();                                                                     // - Машина ждет прибытия (arrive == 0)
            System.out.printf("Автомобиль №%d продолжил движение.\n", carNumber);               // - Машина продолжает путь
        } catch (Exception e) {}
    }
}