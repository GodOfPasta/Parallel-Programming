import java.util.ArrayList;
public class Sorting extends Thread {
    private ArrayList<Train> SortingTrains;    // Очередь поездов на сортировке
    private final int Lines;                   // Количество линий на сортировку
    InputRoad Generator;                       // Генератор новых поездов
    Sorting(InputRoad Road, int lines) {
        this.Lines = lines;
        this.SortingTrains = new ArrayList<>();
        Generator = Road;
    }

    public synchronized void run() {
        try {
            while (true) {
                while (SortingTrains.size() >= Lines) {  // Если сортируется поездов >= чем кол-во линий,
                    wait();                              // поезда не прибывают
                }                                        //

                SortingTrains.add(Generator.getTrain()); // Добавляем новый поезд из генератора
                notifyAll();                             // Разрешаем работать другим потокам
            }
        } catch (InterruptedException e) {
            System.out.println("Exception!");
        }
    }
    public synchronized Train getRequiredTrain(int Type) {
        try {
            while (true) {                                                                      //
                for (Train TrainFound : SortingTrains) {                                        // - Для каждого поезда
                    if (TrainFound.Type == Type) {                                              // - Если поезд соответстует типу
                        SortingTrains.remove(TrainFound);                                       //   - Мы убираем этот поезд из очереди
                        System.out.println("Поезд " + TrainFound.Name + " покидает сортировку");//   - Уведомляем об этом
                        notifyAll();                                                            //   - Разрешаем работать другим потокам
                        return TrainFound;                                                      //   - Возвращаем этот поезд
                    }                                                                           //
                }                                                                               //
                wait();                                                                         // - После проверки всех поездов ожидаем
            }                                                                                   //
        } catch (InterruptedException e) {
            System.out.println("Exception!");
        }
        return null;
    }
}