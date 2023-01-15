public class MultiThreadDemo {
    public static void main(String[] args) {
        new NewThread("One"); // Запустить потоки на исполнение
        new NewThread("Two");
        new NewThread("Three");
        try{
            Thread.sleep(10000);
        }
        catch (InterruptedException e){
            System.out.println("Main thread was interrupted");
        }
        System.out.println("Main thread is finished");
    }
}
