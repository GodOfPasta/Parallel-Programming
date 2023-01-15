import java.util.concurrent.Semaphore;
public class Barbershop {
    int stay, seat, barbers;
    Semaphore sem2, sem3, sem4;
    Barbershop(){
        stay=0;
        seat=0;
        barbers=0;

        sem2 = new Semaphore(7, true);  // Максимальное число клиентов на диване
        sem3 = new Semaphore(3, true);  // Максимальное число клиентов у парикмахеров
        sem4 = new Semaphore(1, true);  // Максимальное число клиентов на кассе
    }


}
