public class NewThread extends Thread{
    NewThread(){
        // создать новый поток исполнения
        super("DemoThread");
        System.out.println("Дочерний поток: " + this);
        start();
    }

    public void run() {
        try{
            for(int i = 5; i > 0; i--){
                System.out.println("Дчерний поток: " + i);
                Thread.sleep(500);
            }
        }
        catch(InterruptedException e){
            System.out.println("Дочерний поток прерван");
        }
        System.out.println("Дочерний поток завершен");
    }
}
