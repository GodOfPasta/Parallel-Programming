public class Bus extends Thread{
    BusStop stop;
    Bus(BusStop stop){
        this.stop = stop;
    }

    public void run() {
        stop.openDoor();
    }
}
