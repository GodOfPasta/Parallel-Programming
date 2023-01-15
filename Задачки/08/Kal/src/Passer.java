public class Passer extends Thread{
    Crossroad cross;
    String name;
    Path path;
    Passer(Path path, int counter, Crossroad cross){
        this.path = path;
        this.cross = cross;
        this.name = "Path" + path.name + ", Passer " + counter;
    }

    public void run() {
        try {
            System.out.println("Создан прохожий " + currentThread().getName());
            if(path.name == 1){
                cross.tryPass();
            }
            else{
                cross.tryPass2();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
