import java.util.concurrent.Semaphore;
public class BusStop {
    int crowd = 0;
    Semaphore CrowdEdit, OpenBus, VirtualTurn;

    BusStop(){
        CrowdEdit = new Semaphore(1);
        OpenBus = new Semaphore(0);
        VirtualTurn = new Semaphore(1);
    }

    public void openDoor(){
        try {
            CrowdEdit.acquire();
                System.out.println("Подошел автобус " + Thread.currentThread().getName() + ", на остановке" + crowd);
                    OpenBus.release(Math.min(50,crowd));
                    Thread.sleep(100);
                System.out.println("Автобус уехал");
            CrowdEdit.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void waitBus(){
        try {
            String name = Thread.currentThread().getName();
            System.out.println("Подходит пассажир " + name);

            VirtualTurn.acquire();
                CrowdEdit.acquire();
                    crowd++;
                    System.out.println("Пассажиров стало " + crowd);
                CrowdEdit.release();
            VirtualTurn.release();

            System.out.println("Зашел на остановку " + name);
            OpenBus.acquire();
            System.out.println("Сел в автобус " + name);
            CrowdEdit.acquire();
                crowd--;
            CrowdEdit.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
