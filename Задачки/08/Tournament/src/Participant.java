import java.util.Random;
import java.util.concurrent.CountDownLatch;
public class Participant extends Thread{
    Random r = new Random();
    CountDownLatch currentBarrier;
    private int myFavoriteNumber;
    boolean winner = false;
    boolean loser = false;
    public int index;
    Participant(int index, CountDownLatch currentBarrier){
        this.index = index;
        this.currentBarrier = currentBarrier;
    }

    public synchronized void run() {
        try {
            while(!winner && !loser){
                    myFavoriteNumber = r.nextInt(10) + 1;
                    System.out.println("Участник №" + index + " загадал " + myFavoriteNumber);
                    currentBarrier.countDown();
                    wait();
                    if(currentBarrier == null){
                        loser = true;
                    }
            }
        } catch (InterruptedException e) {}
    }
    public synchronized int getMyFavoriteNumber(){
        return myFavoriteNumber;
    }
    public synchronized void newRound(CountDownLatch barrier){
        this.currentBarrier = barrier;
        notify();
    }
    public synchronized void win(){
        winner = true;
        System.out.println("Участник " + index + " победил");
        notify();
    }
}
