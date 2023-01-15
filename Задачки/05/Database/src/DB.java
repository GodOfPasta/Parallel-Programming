import java.util.concurrent.Semaphore;
public class DB {
    Semaphore sem1, sem2, sem3; // Три семафора
    int counter = 0;            // Число читателей в Базе данных
    DB(){
        sem1 = new Semaphore(1, true); //
        sem2 = new Semaphore(1, true); // По каждому из трех семафоров можно получить одно разрешение
        sem3 = new Semaphore(1, true); //
    }
}