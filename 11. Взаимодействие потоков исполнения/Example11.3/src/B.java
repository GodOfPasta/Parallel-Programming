public class B {
    synchronized void bar(A a){
        String name = Thread.currentThread().getName();

        System.out.println(name + " вошел в метод А.foo()");

        try{
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Класс А прерван");
        }
        System.out.println(name + " пытается вызвать метод B.last()");
        a.last();
    }

    synchronized void last(){
        System.out.println("В методе A.last()");
    }
}
