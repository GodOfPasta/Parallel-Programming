import java.util.Random;
public class InputRobot extends Thread{
    int index;  // Индекс для детали
    Belt conv;  // Конвейер
    InputRobot(int i, Belt Conv){
        this.index = i;
        this.conv = Conv;
    }

    public void run() {
        Random r = new Random();
        try {
            while(true){
                conv.add(new Detail(), index);                  // Добавление детали на конвейер
                Thread.sleep(r.nextInt(901) + 100);  // Ожидание
            }
        } catch (InterruptedException e) {}
    }
}
