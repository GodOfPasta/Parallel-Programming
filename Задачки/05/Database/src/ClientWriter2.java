public class ClientWriter2 extends Thread {
    int TimeRequired;       // Время, которое Писатель проведет в базе
    String name;            // Имя Писателя
    DB database;            // База данных

    public ClientWriter2(DB database, int counter, int nextInt) {
        this.database = database;
        this.TimeRequired = nextInt;
        this.name = "Writer #" + counter;
    }

    public void run() {
        System.out.println("Создан клиент " + name);                                 // Уведомление о создании Писателя
        try {
            database.sem3.acquire();                                                 // - Запрос доступа по sem3
            database.sem1.acquire();                                                 // - Запрос доступа по sem1
            System.out.println("Клиент " + name + " получил доступ к базе данных");  // - Уведомление о получении доступа
            sleep(TimeRequired);                                                     // - Использование БД (ожидание)
            System.out.println("Клиент " + name + " закончил работу с базой данных");// - Уведомление об освобождении доступа
            database.sem1.release();                                                 // - Освобождение доступа по sem1
            database.sem3.release();                                                 // - Освобождение доступа по sem3
        } catch(InterruptedException e) {
            System.out.println("Исключение!");
        }

    }
}