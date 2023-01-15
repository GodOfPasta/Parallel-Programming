public class MyThread extends Thread {
    private int index;          // Индекс (в общем-то то же самое, что и имя в предыдущем примере)
    private Thread parent;      // Родительский поток (тот, что породил текущий)
    MyThread(int Index, Thread Parent) {
        this.index = Index;
        this.parent = Parent;
    }

    public void run() {
        System.out.println("Thread #" + this.index + " is started");                        // Объявление (в консоли) о запуске потока

        if (this.index < 10) {                                                                //
            MyThread NewThread = new MyThread(this.index + 1, Thread.currentThread());  // Порождение еще одного потока
            NewThread.start();                                                                // с индексом <11
        }                                                                                     //

        try {                                          //
            while(this.parent.isAlive()) {             //
                sleep(100L);                      // Ожидание 100 mls,
            }                                          // пока родительский поток не завершен
        } catch (InterruptedException var2) {          //
        }                                              //

        System.out.println("Thread #" + this.index + " is finished");   // Объявление о завершении потока
    }
}