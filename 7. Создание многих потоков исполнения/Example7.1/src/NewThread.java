public class NewThread extends Thread{
    String name; // имя потока исполнения
    Thread t;
    NewThread(String name){
        super(name);
        this.name = name;
        System.out.println("New thread: " + this);
        start();
    }
    //Точка входа в поток исполнения
    public void run() {
        try{
            for(int i = 5; i > 0; i--){
                System.out.println(name + ": " + i);
                sleep(1000);
            }
        }
        catch (InterruptedException e){
            System.out.println(name + " was interrupted");
        }
        System.out.println(name + " is finished");
    }
}
