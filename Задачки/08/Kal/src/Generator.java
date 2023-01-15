import java.util.Random;

public class Generator extends Thread{
    private int counter = 0;
    Passer newPas;
    Crossroad cross;
    Path path;
    Random roll;
    Generator(Path path, Crossroad cross){
        this.cross = cross;
        this.path = path;
        roll = new Random();
    }

    public void run() {
       try{
           while(true){
               newPas = new Passer(path, counter, cross);
               counter++;
               path.counter++;
               newPas.start();
               System.out.println("На пути Path" + path.name + " сейчас " + path.counter + " человек(а)");
               sleep(roll.nextInt(50) + 50);
           }
       }catch (InterruptedException e){
           System.out.println("InterruptedException!");
           e.printStackTrace();
       }
    }
}