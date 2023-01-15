public class Uploader extends Thread {
    private int Index;          // Индекс поезда
    private int Type;           // Тип поезда
    private Sorting SortLines;  // Сортировка
    Uploader(int index, int type, Sorting sorting){
        this.Index = index;
        this.SortLines = sorting;
        this.Type = type;
    }

    public synchronized void run() {
        try{
            while(true){
                Train train = SortLines.getRequiredTrain(Type);                                                 //
                System.out.println("Поезд " + train.Name + " прибыл на станцию №" + Index);                     // - Уведомление о прибытии на станцию поезда
                for (int i = 1; i <= train.Length; i++) {                                                       // - Ждем по количеству вагонов поезда
                    Thread.sleep(100);                                                                     //
                }                                                                                               //
                System.out.println("Разгрузка поезда " + train.Name + " на станции №" + Index + " окончена");   // - Уведомление о завершении разгрузки
            }                                                                                                   //
        } catch(InterruptedException e)
        {System.out.println("Exception!");}
    }
}