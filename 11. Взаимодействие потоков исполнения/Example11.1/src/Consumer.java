public class Consumer implements Runnable{
    Queue queue;

    Consumer(Queue queue){
        this.queue = queue;
        new Thread(this, "Потребитель").start();
    }

    public void run() {
        while(true){
            queue.get();
        }
    }
}
