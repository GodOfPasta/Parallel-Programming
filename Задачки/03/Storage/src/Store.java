public class Store {
    private int product = 1;     // Начальное число товаров
    private final int shelf = 5; // Максимальное число товаров
    public synchronized void get(){
        try{
            while(product < 1){      //
                wait();              // Если на полке нет товаров, то Покупатель должен подождать
            }                        //

            product--;               // Уменьшение числа товаров

            System.out.println("Покупатель купил 1 товар");     // Уведомление о покупке
            System.out.println("Товара на складе:" + product);  //

            notify();                // Разрешение действовать другим потокам (в данном случае Производителю),
                                     // если для них был вызван метод wait()
        } catch (InterruptedException e) {}
    }
    public synchronized void put(){
        try{
            while(product > shelf-1){ //
                wait();               // Если полки переполнены, то Производитель должен подождать
            }                         //

            product++;                // Увеличение числа товаров

            System.out.println("Производитель добавил 1 товар");    // Уведомление о поступлении
            System.out.println("Товара на складе:" + product);      //

            notify();                 // Разрешение действовать другим потокам (в данном случае Покупателю),
                                      // если для них был вызван метод wait()
        } catch (InterruptedException e) {}
    }
}
