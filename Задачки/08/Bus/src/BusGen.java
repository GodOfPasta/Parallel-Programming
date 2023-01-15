import java.util.Random;
public class BusGen extends Thread{
    Bus newBus;
    BusStop stop;
    Random r = new Random();
    BusGen(BusStop stop){
        this.stop = stop;
    }

    public void run() {
        try{
            while(true){
                sleep(r.nextInt(5000));
                newBus = new Bus(stop);
                newBus.start();
            }
        }catch (InterruptedException e){
            System.out.println("InterruptedException!");
            e.printStackTrace();
        }
    }
}
