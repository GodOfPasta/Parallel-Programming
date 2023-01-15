import java.util.Random;
public class Client extends Thread{
    String name;          // Имя Клиента
    Barbershop shop;      // Парикмахерская
    Random rand = new Random();
    Client(int name, Barbershop barber){
        this.shop = barber;
        this.name = "Клиент №" + name;
        try{                                            //
            sleep(rand.nextInt(200) + 10);   // Клиенты приходят с некоторой периодичностью
        } catch (InterruptedException e) {}             //
    }

    public void run() {
        try {
            System.out.println(name + " пришёл в парикмахерскую");              // Уведомление о том, что клиент пришел в парикмахерскую

            if (shop.stay > 9) {                                                //
                System.out.println(name + " ушёл, так как мест нет");           // Если клиентов в парикмахерской > 9,
                return;                                                         // то клиент уходит
            }                                                                   //
            shop.stay++;                                                        // - Инкремент стоящих
            System.out.println(name + " встал в очередь в стоячей зоне, всего стоит " + shop.stay);
                shop.sem2.acquire();                                                                                        //
                    shop.seat++;                                                                                            // Клиент пытается сесть
                    shop.stay--;                                                                                            // => сидит больше на 1, стоит меньше на 1
                System.out.println(name + " сел на диван, всего сидит " + shop.seat + ", всего стоит " + shop.stay);        //

                shop.sem3.acquire();                                                                                        // Клиент пытается начать стричься
                    shop.barbers++;                                                                                         // => стрижется больше на 1, сидит меньше на 1
                    shop.seat--;                                                                                            //
                System.out.println(name + " стрижется, всего стригутся " + shop.barbers + ", всего сидит на диване " + shop.seat);
                shop.sem2.release();                                                                                        //

                sleep(500);                                               // - Клиент стрижется 500 mls
                shop.barbers--;                                                // - Клиент отошел от парикмахера
                System.out.println(name + " подстрижен и идет оплатить стрижку");
                shop.sem4.acquire();                                           //
                            System.out.println(name + " оплачивает в кассу");  // Клиент заставляет парикмахера
                            sleep(50);                                    // метнуться кабанчиком и заплатить в кассу (за 50 mls)
                shop.sem3.release();                                           // (то есть 1 парикмахер + касса заняты)
                shop.sem4.release();                                           //
            System.out.println(name + " оплатил и уходит");

        } catch (InterruptedException e) {}
    }
}