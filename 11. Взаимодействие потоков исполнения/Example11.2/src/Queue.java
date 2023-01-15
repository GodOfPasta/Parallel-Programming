public class Queue {
    int n;
    boolean valueSet = false;

    synchronized int get(){
        while(!valueSet)
            try{
                wait();
            } catch (InterruptedException e){
                System.out.println("Исключение типа InterruptedException");
            }
        System.out.println("Получено: " + n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n){
        while(valueSet)
            try{
                wait();
            } catch (InterruptedException e){
                System.out.println("Исключение типа InterruptedException");
            }
        this.n = n;
        valueSet = true;
        System.out.println("Отправлено: " + n);
        notify();
    }
}
