public class NewThread implements Runnable {
    Thread t;
    NewThread() {
        // создать новый, второй поток исполнения
        t = new Thread(this, "DemoThread");
        System.out.println("Дочерний поток создан: " + t);
        t.start();
    }
    // Точка входа во второй поток
    @Override
    public void run() {
        try{
            for(int i = 5; i > 0; i--){
                System.out.println("Дочерний поток: " + i);
                Thread.sleep(500);
            }
        }
        catch (InterruptedException e){
            System.out.println("Дочерний поток прерван");
        }
        System.out.println("Дочерний поток завершен");
    }
}
