public class ClientReader extends Thread {
    int TimeRequired;       // Время, которое Читатель проведет в базе
    String name;            // Имя Читателя
    DB database;            // База данных

    public ClientReader(DB database, int counter, int nextInt) {
        this.database = database;
        this.TimeRequired = nextInt;
        this.name = "Reader #" + counter;
    }

    public synchronized void run() {
        System.out.println("Создан клиент " + name);                                 // Уведомление о создании Читателя
        try {
            database.sem2.acquire();                                                 // - Запрос доступа по sem2
                database.counter++;                                                      // - Инкремент числа Читателей в Базе данных
                if (database.counter == 1){                                              // - Если в Базе данных один читатель
                    database.sem1.acquire();                                             //   - Запрос доступа по sem1 (Чтобы не давать доступ Писателям)
                }                                                                        //
            database.sem2.release();                                                 // - Освобождение доступа по sem2

            System.out.println("Клиент " + name + " получил доступ к базе данных");  // - Уведомление о получении доступа
            sleep(TimeRequired);                                                     // - Использование БД (ожидание)
            System.out.println("Клиент " + name + " закончил работу с базой данных");// - Уведомление об освобождении доступа

            database.sem2.acquire();                                                 // - Запрос доступа по sem2 (Чтобы все Читатели получали доступ только одновременно)
                database.counter--;                                                      // - Декремент числа Читателей в Базе данных
                if (database.counter==0){                                                // - Если в Базе данных нет читателей
                    database.sem1.release();                                             //   - Освобождение доступа по sem1 (Чтобы следующий Писатель мог получить доступ)
                }                                                                        //
            database.sem2.release();                                                 // - Освобождение доступа по sem2 (Чтобы следующий Читатель мог получить доступ)\

        } catch(InterruptedException e) {
            System.out.println("Исключение!");
        }
    }
}
