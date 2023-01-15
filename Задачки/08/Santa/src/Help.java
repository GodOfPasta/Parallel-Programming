public class Help implements Runnable{

    public void run() {
        try{
            System.out.println("Санта помогает эльфам");    // При вызове этого потока Санта помогает эльфам
            Thread.sleep(1000);                        // на протяжении 1000 mls
        }catch (InterruptedException e){
            System.out.println("InterruptedException");
        }
    }
}
