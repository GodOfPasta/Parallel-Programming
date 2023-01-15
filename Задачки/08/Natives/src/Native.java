public class Native extends Thread{
    Pot pot;
    Native(Pot pot){
        this.pot = pot;
    }

    public void run() {
        while(true){
            pot.getFood();
        }
    }
}
