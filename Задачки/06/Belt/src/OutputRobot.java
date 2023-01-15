public class OutputRobot extends Thread{
    Belt conv;      // Конвейер
    Detail detail;  // Деталь
    OutputRobot(Belt Conv){
        this.conv = Conv;
    }

    public void run() {
        try {
            while(true) {
                detail = conv.getDetail();                                                          // Снятие детали с конвейера
                System.out.println("Деталь №" + detail.index + " снята с конвейера Разгрузчиком");
                Thread.sleep(400);                                                             // Ожидание
            }
        } catch (InterruptedException e) {}
    }
}
