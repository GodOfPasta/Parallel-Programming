import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
public class Belt {
    private ArrayList<Detail> conv;         // Детали на конвейере
    final private int CriticalMass = 4000;  // Критическая масса
    private int CurrentMass;                // Текущая масса
    ReentrantLock lock;                     // Лок
    Condition EmptyBelt;                    // Состояние
    Belt(){
        this.conv = new ArrayList<>();
        this.CurrentMass = 0;
        this.lock = new ReentrantLock();
        EmptyBelt = lock.newCondition();
    }
    public void add(Detail A, int i){
        lock.lock();                                                                            // Блокируем блок кода для синхронизации
        try{
            conv.add(A);                                                                        // Добавляем деталь на конвейер
            System.out.println("Деталь №" + A.index + " поставлена на конвейер Роботом " + i);
            CurrentMass += A.mass;                                                              // Увеличиваем текущую массу на массу новой детали
            System.out.println("Общая масса деталей: " + CurrentMass);
            if (CurrentMass > CriticalMass){                                                    //
                BeltClear();                                                                    // - Если масса всех деталей > критической
            } else {                                                                            //   массы - конвейер очищается
                EmptyBelt.signalAll();                                                          // - Иначе оповещаем другие потоки (Разгрузчика)
            }                                                                                   //   о том, что детали появились
        } catch (InterruptedException e) {}
        finally {
            lock.unlock();                                                                      // Разблокируем блок (всегда делается в finally)
        }
    }
    public Detail getDetail(){
        lock.lock();                                // Блокируем блок кода для синхронизации
        Detail temp = null;                         //
        try {
            while (conv.size() == 0){               // - Пока на конвейере нет деталей
                EmptyBelt.await();                  //   - Разгрузчик ожидает
            }                                       //
            temp = conv.remove(0);            // - Извлекается первая деталь
            CurrentMass -= temp.mass;               // - Уменьшается текущая масса
        } catch (InterruptedException e) {}
        finally {
            lock.unlock();                          // Разблокируем блок (всегда делается в finally)
        }
        return temp;
    }
    public void BeltClear() throws InterruptedException {
        System.out.println("Началась очистка ленты");
        System.out.println("Всего " + conv.size() + " деталей массой " + CurrentMass);
        Thread.sleep(500);
        conv.clear();
        CurrentMass=0;
    }

}
