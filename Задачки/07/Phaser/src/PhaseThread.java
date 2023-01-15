import java.util.concurrent.Phaser;
public class PhaseThread implements Runnable{
    Phaser phaser;      // Фазер
    String name;        // Имя
    PhaseThread(Phaser p, String n){
        this.name = n;
        this.phaser = p;
        phaser.register();  // Регистрируем участника
    }

    public void run() {
        for (int i = 0; i < 5; i++){
            System.out.println(name + " выполняет фазу " + phaser.getPhase());  // Уведомление о начале выполнении фазы
            //Полезная работа
            phaser.arriveAndAwaitAdvance();                                     // Ожидание, пока все потоки с этим фазером начнут выполнять фазу
            try{
                Thread.sleep(100);                                         // "Выполнение" фазы
            } catch (InterruptedException e) {}
        }
        System.out.println(name + " выполняет фазу " + phaser.getPhase());      // Выполнение последней фазы
        phaser.arriveAndDeregister();                                           // Дерегистрация участника
    }
}