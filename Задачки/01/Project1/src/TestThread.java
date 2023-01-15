public class TestThread extends Thread{
    private String name;                            // Имя потока
    TestThread(int I){
        this.name="MyThread #" + I;                 // Определение имени потока
        System.out.println(this.name + " created"); // Объявление (в консоли) о создании потока
    }

    @Override
    public void run() {
        System.out.println(name + " started");      // Объявление о запуске потока
        int counter = 1;                            // Просто счётчик

        while (!isInterrupted())                    // Поток действует дод тех пор, пока не будет прерван
        {
            System.out.println("Step " + counter++); // Поток просто выводит "Step 'counter'" и увеличивает значение счетчика
            try {
                Thread.sleep(100);              // И ждет 100 mls
            } catch (InterruptedException e) {
                System.out.println("Interruption");
                interrupt();
            }
        }
        System.out.println(name + " finished");     // Объявление о завершении (после прерывания)
    }

}
