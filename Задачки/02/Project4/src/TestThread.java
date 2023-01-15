import java.io.PrintStream;
public class TestThread extends Thread {
    CommonResource res;      // Некие данные (в этом случае наша заглушка)
    TestThread(CommonResource Res) {
        this.res = Res;
    }

    public void run() {
        // В этот блок не могут одновременно зайтии два потока
        synchronized(res) {  // Синхронизация происходит по объекту
            this.res.x = 0;  // Установка данных на 0 (Если этого не сделать они будут увеличиваться на каждом потоке)

            for(int i = 0; i < 4; ++i) {                          //
//              PrintStream var0 = System.out;                    //  - [Понятия не имею, зачем тут это]
                String name = Thread.currentThread().getName();   //  - Запоминаем имя текущего потока
//              var0.println(name + ": " + this.res.x);           //
                System.out.println(name + ": " + ++this.res.x);   //  - Выводим значение инкремента данных
                                                                  //    для текущего потока

                try {                               //
                    Thread.sleep(200L);        // Ожидаем 200 mls
                } catch (InterruptedException e) {  //
                }
            }
        }
    }
}