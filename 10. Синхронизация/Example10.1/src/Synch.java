public class Synch {
    public static void main(String[] args) {
        CallMe target = new CallMe();
        Caller ob1 = new Caller(target, "Welcome");
        Caller ob2 = new Caller(target, "to the synchronized");
        Caller ob3 = new Caller(target, "world!");
        // Ожидать завершение потока исполнения
        try{
            ob1.join();
            ob2.join();
            ob3.join();
        }catch (InterruptedException e){
            System.out.println("Interrupted");
        }
    }
}
