import java.util.concurrent.CountDownLatch;
public class FerryBoat implements Runnable {
    CountDownLatch latch;
    CountDownLatch arrive;
    public FerryBoat(CountDownLatch latch, CountDownLatch arrive){
        this.latch = latch;
        this.arrive = arrive;
        new Thread(this).start();
    }
    public synchronized void run() {
        try {
            latch.await();                                      // - Паром ожидает прибытия всех машин (latch == 0)
            System.out.println("Паром поплыл!");                // - Паром плывёт 500 mls
            Thread.sleep(500);                             //
            arrive.countDown();                                 // - Паром уменьшает arrive на 1
            System.out.println("Паром переправил автомобили!"); // - Уведомление о переправе
        } catch (InterruptedException e) {}
    }
}