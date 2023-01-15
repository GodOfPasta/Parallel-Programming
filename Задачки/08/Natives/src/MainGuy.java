public class MainGuy extends Thread{
    Pot pot;
    MainGuy(Pot pot){
        this.pot = pot;
    }

    public void run() {
        while(true){
            pot.putFood();
        }
    }
}
