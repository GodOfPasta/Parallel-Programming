public class Consumer extends Thread{
    Store store;    // Магазин, в котором злодействует покупатель
    Consumer(Store store){
        this.store = store;
    }
    @Override
    public void run() {                 //
        for (int i = 0; i < 10; i++){   //
            store.get();                // Покупатель пытается взять 10 товаров
        }                               //
    }                                   //
}