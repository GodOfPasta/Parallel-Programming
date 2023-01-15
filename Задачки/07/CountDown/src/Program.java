import java.util.concurrent.CountDownLatch;

public class Program {
    private static final CountDownLatch latch = new CountDownLatch(9), arrive = new CountDownLatch(1);
    public static void main(String[] args) throws InterruptedException {
        new FerryBoat(latch, arrive);
        for (int i = 0; i < 9; i++) {
            new Thread(new Car(i, latch, arrive)).start();
            Thread.sleep(200);
        }
    }
    // Смысл программы:
    // Самой задачи я не видел, поэтому сформулирую как понял из решения
    // - Есть 9 машин, подъезжающих к паромной переправе с интервалом в 200 mls
    // - Паром может перевезти 9 машин, но поедет он только по заполнению
    // - Переправа занимает 500 mls
    // - Машины могут продолжить движение только после того, как паром завершит переправу
    // - Для решения этой задачи был использован CountDownLatch
    //   - latch имеет счетчик на 9 - он показывает, сколько машин приехало на паром
    //   - arrive имеет счетчик на 1 - он показывает, закончил ли паром переправу
    // - После того, как машина подъехала к переправе, latch с помощью метода countDown() уменьшается на 1.
    //   По принятию latch значения 0 Паром начинает переправу с помощью метода await()
    // - После того, как паром завершит переправу, arrive с помощью метода countDown() уменьшается на 1.
    //   По принятию latch значения 0 машины продолжают движение с помощью метода await()
}