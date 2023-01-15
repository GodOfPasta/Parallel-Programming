import java.util.Random;
public class Generator extends Thread{
    private int Counter = 0; // Кол-во пользователей
    DB database;             // База данных
    Random r = new Random();
    Generator(DB Data){
        database = Data;
    }

    public synchronized void run() {
        try{
            while(true){                                                                                    //
                Thread t;                                                                                   // - Объявляем нового пользователя
                if (r.nextInt(100)<30){                                                               //
                    t = new Thread(new ClientWriter2(database, Counter, r.nextInt(900)+100));   // - с 30% шансом это Писатель
                }                                                                                           //
                else{                                                                                       //
                    t = new Thread(new ClientReader2(database, Counter, r.nextInt(900)+100));   // - с 70% шансом это Читатель
                }                                                                                           //
                Counter++;                                                                                  // - Инкриминируем кол-во пользователей
                t.start();                                                                                  // - "Запускаем" пользователя
                sleep(r.nextInt(300));                                                                // - Ждем перед запуском (0-300) mls
            }                                                                                               //
        } catch(InterruptedException e)
        {System.out.println("Exception!");}
    }
}