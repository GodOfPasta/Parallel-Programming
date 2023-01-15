public class Person {
    private static final Object lock = new Object(); // Зачем это надо написано в Program
    private String name;        // У человека есть имя
    public String getName() {   //
        return this.name;       // Геттер для имени
    }                           //
    public Person(String Name) {
        this.name = Name;
    }
    public void bow(Person friend) {                                                    //
        synchronized (lock) {                                                           //
            System.out.println(this.name + ": " + friend.getName() + " поклонился");    // Метод для поклона.
            friend.bowBack(this);                                                 // Вызывает обратный поклон
        }                                                                               //
    }                                                                                   //
    public synchronized void bowBack(Person friend) {                                     //
        System.out.println(this.name + ": " + friend.getName() + " поклонился в ответ");  // Обратный поклон
    }                                                                                     //
}