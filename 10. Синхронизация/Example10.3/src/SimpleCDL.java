import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class SimpleCDL {
    public static void main(String[] args) {
        // задаем кол-во потоков
        final int THREADS_COUNT = 6;
        // задаем значение счётчика
        final CountDownLatch cdl = new CountDownLatch(THREADS_COUNT);
        System.out.println("Start");
        for(int i = 0; i < THREADS_COUNT; i++) {
            final int w = i;
            new Thread(() -> {
                try {
                    // Положим, что выполнение задачи занимает ~1 сек
                    Thread.sleep(500 + (int) (500 * Math.random()));
                    // Когда задача выполнена - уманьшаем счетчик
                    cdl.countDown();
                    System.out.println("Thread #" + w + " is ready");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        try{
            // Ждем, пока счетчик не сбросится в 0, пока это не
            // произойдет, будем стоять на этой строке
            cdl.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        // Когда все потоки выполнены - пишем сообщение
        System.out.println("Work is done");
    }
}
