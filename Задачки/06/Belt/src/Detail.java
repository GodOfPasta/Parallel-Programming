import java.util.Random;
public class Detail {
    int mass;   // Масса детали
    int index;  // Индекс детали
    static int number = 0;
    Detail(){
        Random r = new Random();
        this.index = ++number;
        this.mass = r.nextInt(201) + 300;
    }
}
