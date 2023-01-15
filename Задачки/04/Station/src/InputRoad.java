import java.util.ArrayList;
public class InputRoad extends Thread{
    private ArrayList<Train> TrainList; // Очередь всех поездов
    Train First;                        // Первый поезд
    private int Counter = 0;            // Кол-во поездов
    private final int maxLength = 10;   // Максимальное кол-во поездов
    InputRoad(){
        TrainList = new ArrayList<>();
    }

    public synchronized void run() {
        try{
            while(true){                                 //
                while (TrainList.size() >= maxLength){   // - Поезда не приезжают, если их кол-во >= максимуму
                    wait();                              //
                }                                        //
                Counter++;                               // - Инкремент числа поездов
                TrainList.add(new Train(Counter));       // - Добавляем новый поезд к очереди поездов
                notifyAll();                             // - Разрешаем работать другим потокам
            }                                            //
        } catch(InterruptedException e)
        {System.out.println("Exception!");}
    }
    public synchronized Train getTrain(){
        try {                                           //
            while (TrainList.size() == 0) {             // Если поездов нет - они не могут уехать
                wait();                                 //
            }                                           //
        } catch(InterruptedException e)                 //
        {System.out.println("Exception!");}             //

        First = TrainList.get(0);                                                   //
        System.out.println("Поезд " + First.Name + " отправляется на сортировку");  // Уезжает первый в очереди поезд
        TrainList.remove(0);                                                   //
        notifyAll();                                    // Разрешаем работать другим потокам
        return First;
    }
}
