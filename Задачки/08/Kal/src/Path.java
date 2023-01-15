import java.util.concurrent.Semaphore;

public class Path {
    int name;
    int counter = 0;
    Semaphore passing;
    Path(int i){
        name = i;
        passing = new Semaphore(1,true);
    }
}
