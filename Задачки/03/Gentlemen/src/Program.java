public class Program {
    public static void main(String[] args) throws InterruptedException {
        Person alphonse = new Person("Alphonse");   // Два человека
        Person gaston = new Person("Gaston");       //

        Meeting today1 = new Meeting(alphonse, gaston);   // Две встречи
        Meeting today2 = new Meeting(gaston, alphonse);   //

        today1.start();             // Запускаем первую встречу: Alphonse встречает Gaston
        //Thread.sleep(100L);    // Главный поток ждет 100 mls
        today2.start();             // Запускаем вторую встречу: Gaston встречает Alphonse

        // Программа демонстрирует вход из дэдлока
        // - Если не будет строки с sleep(), то оба потока попытаются вызвать метод bowBack(),
        //   в то время, как мониторы этих объектов уже заняты методом bow().
        // - Мне это решение не понравилось, поэтому я добавил в класс Person
        //   переменную lock, которая отвечает за то, что если в этом блоке
        //   есть какой-то другой поток с объектом того же класса, что и отслеживаемый
        //   (в данном случае lock класса Object), то другой поток в этот блок входить не будет

    }
}