public class Passenger extends Thread{
    BusStop stop;
    Passenger(BusStop stop){
        this.stop = stop;
    }

    public void run() {
        stop.waitBus();
    }
}
