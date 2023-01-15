public class Synch {
    public static void main(String[] args) {
        CallMe target = new CallMe();
        Caller ob1 = new Caller(target, "Добро пожаловать");
        Caller ob2 = new Caller(target, "в синхронизированный");
        Caller ob3 = new Caller(target, "мир!");
        // ожидать завершения потока исполнения
        try {
            ob1.join();
            ob2.join();
            ob3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
