public class FerryBoat implements Runnable{

    public void run() {
        try {
            System.out.println("Паром поплыл");
            Thread.sleep(500);
            System.out.println("Паром переправил автомобили");
        } catch (InterruptedException e) {}
    }
}
