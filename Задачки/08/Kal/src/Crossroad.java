
public class Crossroad {
    Path path1, path2;
    Crossroad(Path path1, Path path2){
        this.path1 = path1;
        this.path2 = path2;
    }
     public synchronized void tryPass() throws InterruptedException {
             while(path2.counter > path1.counter){
                 wait();
             }
         try  {
             path1.passing.acquire();
                 System.out.println("Прохожий " + Thread.currentThread().getName() + " проходит перекресток");
                 Thread.sleep(100);
                 System.out.println("-- Прохожий " + Thread.currentThread().getName() + " прошёл");
                 path1.counter--;
                 System.out.println("На пути Path" + path1.name + " сейчас " + path1.counter + " человек(а)");
             path1.passing.release();
             notifyAll();
         }catch (InterruptedException e){
             System.out.println("InterruptedException!");
             e.printStackTrace();
         }
     }
    public synchronized void tryPass2() throws InterruptedException {
                while(path1.counter >= path2.counter){
                    wait();
                }

        try {
            path2.passing.acquire();
                System.out.println("Прохожий " + Thread.currentThread().getName() + " проходит перекресток");
                Thread.sleep(100);
                System.out.println("-- Прохожий " + Thread.currentThread().getName() + " прошёл");
                path2.counter--;
                System.out.println("На пути Path" + path2.name + " сейчас " + path2.counter + " человек(а)");
            path2.passing.release();
            notifyAll();
        }catch (InterruptedException e){
            System.out.println("InterruptedException!");
            e.printStackTrace();
        }
    }
}
