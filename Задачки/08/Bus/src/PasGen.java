import java.util.Random;

public class PasGen extends Thread{
    Passenger newPas;
    BusStop stop;
    Random r = new Random();
    PasGen(BusStop stop){
        this.stop = stop;
    }

    public void run() {
        try{
            while(true){
                sleep(r.nextInt(100));
                newPas = new Passenger(stop);
                newPas.start();
            }
        }catch (InterruptedException e){
            System.out.println("InterruptedException!");
            e.printStackTrace();
        }
    }
}