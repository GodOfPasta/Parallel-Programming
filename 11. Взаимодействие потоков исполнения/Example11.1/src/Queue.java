public class Queue {
    int n;

    synchronized int get(){
        System.out.println("Получено: " + n);
        return n;
    }

    synchronized void put(int n){
        this.n = n;
        System.out.println("Отправлено: " + n);
    }
}
