public class Synchronized {
    public static void main(String[] args) {
        Test test = new Test();
        Thread t1 = new Thread(() ->  test.show());
        Thread t2 = new Thread(() ->  test.show());

        t1.start();
        t2.start();
    }
}

class Test {
   // void show(){
   synchronized void show(){
        System.out.println("Inside show ");

        try{
            Thread.sleep(2000);
        } catch (Exception e) {}
       //System.out.println("show finish ");
        System.out.println(Thread.currentThread().getName() +"show finish ");
    }
}