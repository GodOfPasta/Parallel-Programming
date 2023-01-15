public class Producer implements Runnable{
    Queue queue;

    Producer(Queue queue){
        this.queue = queue;
        new Thread(this, "Поставщик").start();
    }

    public void run() {
        int i = 0;
        while (true){
            queue.put(i++);
        }
    }
}
