import java.util.concurrent.Phaser;
public class Program {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);                          // Создаем фазер
        new Thread(new PhaseThread(phaser, "Thread1")).start();     // Создаем два потока, в каждый передаем по фазеру
        new Thread(new PhaseThread(phaser, "Thread2")).start();     //

        for (int i = 0; i < 6; i++) {
            phaser.arriveAndAwaitAdvance();                                         // Ожидание, пока все порожденные потоки закончат фазу
            System.out.println("Фаза " + (phaser.getPhase() - 1) + " завершена");   // Уведомление о завершении фазы
        }
        phaser.arriveAndDeregister();
    }
    // Смысл программы:
    // - Есть два потока и 5 фаз работы
    // - Оба потока должны выполнять каждую фазу вместе
    // - В конструкторах каждого из потоков есть метод register() - он регистрирует
    //   участников (не знаю, что это значит, но так надо)
    // - В методах run() (и в цикле в main()) в циклах есть метод arriveAndAwaitAdvance(), который
    //   заставляет поток ожидать завершения фазы для всех потоков имеющих фазер.
    // - В конце всех потоков есть метод arriveAndDeregister(), который завершает потоки
}
