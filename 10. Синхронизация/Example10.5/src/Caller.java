public class Caller extends Thread{
    String msg;
    CallMe target;

    public Caller(CallMe target, String msg){
        super();
        this.msg = msg;
        this.target = target;
        start();
    }
    @Override
    public void run() {
        synchronized (target){
            // Это синхронизированный блок
            target.call(msg);
        }
    }
}
