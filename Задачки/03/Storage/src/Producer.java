public class Producer extends Thread{
    Store store;    // Магазин, в котором непотребствует производитель
    Producer(Store store){
        this.store = store;
    }
    @Override
    public void run() {                 //
        for (int i = 0; i < 10; i++){   //
            store.put();                // Производитель пытается положить 10 товаров
        }                               //
    }                                   //
}