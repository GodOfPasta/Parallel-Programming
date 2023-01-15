public class ThreadDemo {
    public static void main(String[] args) {
        // Раньше
        //NewThread nt = new NewThread();
        //nt.t.start();

        // Теперь
        NewThread nt = NewThread.createAndStart();
        try{
            for(int i = 5; i > 0; i--){
                System.out.println("Главный поток: " + i);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e){
            System.out.println("Главный поток прерван");
        }
        System.out.println("Главный поток завершен");
    }
}