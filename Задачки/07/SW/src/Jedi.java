import java.util.concurrent.Exchanger;
public class Jedi extends Thread{
    Exchanger<String> exchanger;    // Exchanger для обмена строками
    String message;                 // Сообщение, которое будем передавать
    String phrase;                  // Сообщение, которое ожидаем получить
    Jedi(Exchanger<String> ex){
        this.exchanger = ex;
        this.message = "Hello there!";
    }

    public void run() {
        try {
            Thread.sleep(700);                             // Ожидание (для демонстрации работы барьера)
            System.out.println("Jedi has arrived");             // Уведомление о прибытии джедая
            phrase = exchanger.exchange(message);               // Ожидание получения объекта (сообщения) из другого потока
            System.out.println("Jedi has received: " + phrase); // Уведомление о получении сообщения
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
