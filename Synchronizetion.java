public class Synchronizetion {
     public static void main(String[] args)  throws InterruptedException{
        Counter c1 = new Counter();
       // Thread t1 = new Thread(() ->  c1.increment() );
        // Thread t2 = new Thread(() ->  c1.increment() );

        Thread t1 = new Thread(() -> {
            for(int i =1; i<=10000; i++){
                c1.increment();
            }
        });

         Thread t2 = new Thread(() -> {
            for(int i =1; i<=10000; i++){
                c1.increment();
            }
        });


         t1.start();
         t2.start();

         t1.join();
         t2.join();

         System.out.println(c1.count);

    }
}
class Counter {
    public int count = 0;

    synchronized void increment(){
        count++;
    }
}