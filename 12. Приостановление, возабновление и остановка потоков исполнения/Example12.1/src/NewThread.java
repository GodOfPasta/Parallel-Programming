public class NewThread implements Runnable{
    String name;
    Thread t;
    boolean suspendFlag;

    NewThread(String threadName){
        name = threadName;
        t = new Thread(this, name);
        System.out.println("Новый поток: " + t);
        suspendFlag = false;
        t.start();
    }
    //Точка входа в поток исполнения

    @Override
    public void run() {
        try {
            for(int i = 15; i > 0; i--){
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
                synchronized (this){
                    while(suspendFlag){
                        wait();
                    }
                }
            }
        }catch (InterruptedException e){
            System.out.println(name + " прерван");
        }
        System.out.println(name + " завершен");
    }
    synchronized void mySuspend(){
        suspendFlag = true;
    }
    synchronized void myResume(){
        suspendFlag = false;
        notify();
    }
}
