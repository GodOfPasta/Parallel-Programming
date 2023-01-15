import java.util.concurrent.Exchanger;
public class Sith extends Thread{
    Exchanger<String> exchanger;    // Exchanger для обмена строками
    String message;                 // Сообщение, которое будем передавать
    String phrase;                  // Сообщение, которое ожидаем получить
    Sith(Exchanger<String> ex){
        this.exchanger = ex;
        this.message = "General Kenobi!";
    }

    public void run() {
        try {
            System.out.println("Sith has arrived");             // Уведомление о прибытии ситха
            phrase = exchanger.exchange(message);               // Ожидание получения объекта (сообщения) из другого потока
            System.out.println("Sith has received: " + phrase); // Уведомление о получении сообщения
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
