import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
public class Santa extends Thread{
    CyclicBarrier NeedHelp;
    Santa(){
        NeedHelp = new CyclicBarrier(4, new Help());        // Барьеру задается счетчик на 4, т.к. помощь начинается
    }                                                             // только если уже есть Санта + 3 Эльфа, которым он будет помогать

    public void run() {
        while(true){
            try{
                System.out.println("Санта спит");
                NeedHelp.await();                                  // - Санта спит и ждет, пока не будет нужна помощь
                System.out.println("Санта закончил помощь");       // - Если был вызван поток Help, то Санта помог
            }catch (InterruptedException e){
                System.out.println("InterruptedException!");
            }catch (BrokenBarrierException e){
                System.out.println("BrokenBarrierException!");
            }
        }
    }
}
