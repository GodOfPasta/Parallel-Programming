public class Meeting extends Thread {
    private Person Man1; // Встреча - это два человека
    private Person Man2; //
    Meeting(Person A, Person B) {
        this.Man1 = A;
        this.Man2 = B;
    }

    public void run() {             //
        this.Man1.bow(this.Man2);   // Первый человек кланяется второму
    }                               //
}
