public class ClientWriter extends Thread {
    int TimeRequired;       // Время, которое Писатель проведет в базе
    String name;            // Имя Писателя
    DB database;            // База данных

    public ClientWriter(DB database, int counter, int nextInt) {
        this.database = database;
        this.TimeRequired = nextInt;
        this.name = "Writer #" + counter;
    }

    public void run() {
        System.out.println("Создан клиент " + name);                                 // Уведомление о создании Писателя
        try {
            database.sem1.acquire();                                                 // - Запрос доступа по sem1
                System.out.println("Клиент " + name + " получил доступ к базе данных");  // - Уведомление о получении доступа
                sleep(TimeRequired);                                                     // - Использование БД (ожидание)
                System.out.println("Клиент " + name + " закончил работу с базой данных");// - Уведомление об освобождении доступа
            database.sem1.release();                                                 // - Освобождение доступа по sem1
        } catch(InterruptedException e) {
            System.out.println("Исключение!");
        }

    }
}