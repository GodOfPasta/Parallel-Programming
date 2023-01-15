public class Caller extends Thread{
    String msg;
    CallMe target;
    public Caller(CallMe target, String msg){
        super();
        this.target = target;
        this.msg = msg;
        start();
    }
    public void run() {
        target.call(msg);
    }
}
