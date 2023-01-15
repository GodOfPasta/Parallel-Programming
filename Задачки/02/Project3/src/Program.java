public class Program {
    public static void main(String[] args) {
        System.out.println("Main Thread Started");                      // Объявление о запуске главного потока

        MyThread t = new MyThread(1, Thread.currentThread());     // Создание и запуск
        t.start();                                                      // дочернего потока

        try {                                       //
            Thread.sleep(3000L);               // Главный поток ждет 3000 mls
        } catch (InterruptedException var3) {       //
        }                                           //

        System.out.println("Main Thread Finished"); // Объявление о завершении главного потока

        // Программа работает так:
        // - Запускается главный поток
        // - Он порождает дочерний, который ждет 100 mls, каждые 100 mls
        // - Он порождает дочерний, etc, пока не появится 10 потоков
        // - Главный поток ждет 3000 mls, после чего естественным образом завершается
        // - С шагом ~100 mls поочереди завершаются "вложенные" потоки
    }
}