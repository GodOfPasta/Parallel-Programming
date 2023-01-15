public class DemoJoin {
    public static void main(String[] args) {
        NewThread ob1 = new NewThread("One");
        NewThread ob2 = new NewThread("Two");
        NewThread ob3 = new NewThread("Three");

        System.out.println("Thread One is started: " +
                            ob1.isAlive());
        System.out.println("Thread Two is started: " +
                            ob2.isAlive());
        System.out.println("Thread Three is started: " +
                            ob3.isAlive());
        // Ожидать завершения потоков

        try{
            System.out.println("Waiting for threads finish");
            ob1.join();
            ob2.join();
            ob3.join();
        }
        catch (InterruptedException e){
            System.out.println("Main thread was interrupted");
        }

        System.out.println("Thread One is started: " +
                ob1.isAlive());
        System.out.println("Thread Two is started: " +
                ob2.isAlive());
        System.out.println("Thread Three is started: " +
                ob3.isAlive());
        System.out.println("Main thread is finished");
    }
}
