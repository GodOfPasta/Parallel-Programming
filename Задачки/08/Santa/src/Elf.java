import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Semaphore;

public class Elf extends Thread{
    Santa claus;
    Random r = new Random();
    static Semaphore queue = new Semaphore(3);  // Чтобы вызвать Санту, нужно накопить 3 эльфа
    Elf(Santa claus){
        this.claus = claus;
    }

    public void run() {
        while(true){
            try{
                sleep(200 + r.nextInt(600));                                                // - Эльфу нужна помощь через (200 - 800) mls
                System.out.println("Эльфу " + Thread.currentThread().getName() + " нужна помощь!");    //
                queue.acquire();                                                                       // - Каждый эльф, которому нужна помощь занимает 1 "ячейку" семафора
                claus.NeedHelp.await();                                                                // - Когда таких эльфов набирается 3 они призывают Санту
                queue.release();                                                                       // - После этого они освобождают семафор
                System.out.println("Эльф " + Thread.currentThread().getName() + " продолжает работу");
            }catch (InterruptedException e){
                System.out.println("InterruptedException!");
            }catch (BrokenBarrierException e){
                System.out.println("BrokenBarrierException!");
            }
        }
    }
}
