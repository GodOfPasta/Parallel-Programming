import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Pot {
    ReentrantLock Spoon, Chief;  // Когда Туземец что-то ест, он запрещает есть другим (ложка то одна)
                                 // Когда просыпается Шеф он не дает тому, у кого есть ложка уйти
    Condition Empty, Full;
    private int food;
    private final int maxFood;
    Pot(int amount){
        this.maxFood = amount;
        this.food = amount;
        Chief = new ReentrantLock();
        Spoon = new ReentrantLock(false);  // У ложки нет порядка - кто успел, тот её и забрал

        Empty = Chief.newCondition();          // То, пустой котёл или полный влияет на Шефа
        Full = Chief.newCondition();           //
    }
    public void putFood(){
        Chief.lock();              // Если Шеф работает - никто не ест
        try{
            Empty.await();                                                      // - Шеф ждет, пока ему скажут, что котел пуст
            while(food < maxFood){                                              // - Пока котел не полон
                System.out.println("Шеф готовит еду " + food + "/" + maxFood);  //   - Шеф кладет в него еду
                food++;                                                         //
                Thread.sleep(50);                                          //
            }                                                                   //
            System.out.println("Котел полный");                                 // - Когда котел заполнен
            Full.signal();                                                      // - Шеф говорит, что котел заполнен
        }catch (InterruptedException e){
            System.out.println("Произошла чудовищная ошибка");
        }finally {
            Chief.unlock();        // Шеф идет спать
        }
    }
    public void getFood(){
        Spoon.lock();              // Туземцу, чтобы есть, нужно взять ложку
        Chief.lock();              // Только тот, у кого есть ложка, может будить Шефа
        try{
            if(food == 0){                                                                  // - Если в котле нет еды
                System.out.println(Thread.currentThread().getName() + " будит Шефа");      //   - Туземец будит Шефа
                Empty.signal();                                                             //   - Сигнализирует о том, что котел пуст
                while(food < maxFood){                                                      //   - Пока котел не будет заполнен
                    Full.await();                                                           //     - Он ждет заполнения
                }                                                                           //
            }                                                                               // - Иначе (если в котле была еда или Шеф его заполнил)
            System.out.println(Thread.currentThread().getName() + " собрался есть");        // - Туземец ест 100 mls
            Thread.sleep(100);                                                         //
            food--;                                                                         // - Кол-во еды уменьшается
            System.out.println(Thread.currentThread().getName() + " поел. В котле осталось " + food);
        }catch (InterruptedException e){
            System.out.println("Произошла чудовищная ошибка");
        }finally {
            Spoon.unlock();        // После того как Туземец поел, он отпускает ложку (и Шефа)
            Chief.unlock();        // (даже если произошла ошибка)
        }
    }
}
