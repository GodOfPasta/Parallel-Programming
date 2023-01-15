public class Program {

    public static void main(String[] args) throws InterruptedException {

//        System.out.println("Main thread started");  // Объявление о запуске главного потока. Главный поток есть Всегда
//
//        Thread[] MyThread = new Thread[5];          // Объявление массива потоков
//
//        for (int i=0; i<5; i++){                           //
//           MyThread[i] = new Thread(new TestThread(i));    // Заполнение массива потоками
//           MyThread[i].start();                            // и их запуск
//        }                                                  //
//
//        for (int i=0; i<5; i++){                           //
//           MyThread[i].join();                             // Здесь главный поток (main) ждет,
//        }                                                  // пока завершатся порожденные (они не завершатся)
//
//        System.out.println("Main thread finished");        // Объявление о завершении главного потока

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
        System.out.println("Main thread started");           // Объявление о запуске главного потока.

        TestThread MyThread = new TestThread(1);           // Объявляем один поток (передаем имя '1')
        MyThread.start();                                    // Запускаем его

        Thread.sleep(1000);                             // Главный поток ждет 1000 mls;
        MyThread.interrupt();                                // Прерывает порожденный поток;
        Thread.sleep(1000);                             // Ждет 1000 mls

        System.out.println("Main thread finished");          // Объявление о завершении главного потока
    }
}
