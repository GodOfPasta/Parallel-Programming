public class Program {
    public static void main(String[] args) {
        Path p1 = new Path(1);
        Path p2 = new Path(2);
        Crossroad cross = new Crossroad(p1, p2);
        Generator path1 = new Generator(p1, cross);
        Generator path2 = new Generator(p2, cross);

        path1.start();
        path2.start();
    }
}
