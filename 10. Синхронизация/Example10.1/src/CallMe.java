// Эта программа не синхронизирована
public class CallMe {
    synchronized void call(String msg){
        System.out.print("[" + msg);

        System.out.println("]");
    }
}
