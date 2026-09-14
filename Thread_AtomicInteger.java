import java.util.concurrent.atomic.AtomicInteger;

public class Thread_AtomicInteger {
    public static void main(String[] args) {
        
        counter counter = new counter();
        Thread t1 = new Thread(() -> {
            for(int i= 1; i<=1000; i++){
                counter.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for(int i= 1; i<=1000; i++){
                counter.increment();
            }
        });
        t1.start();
        t2.start();

        try{
            Thread.sleep(2000);
        } catch ( InterruptedException e ){
            System.out.println(counter.count);
        }
    }
}

class counter {
    //int count = 0;
    AtomicInteger count = new AtomicInteger(0);

    void increment(){
        count.incrementAndGet();
    }



}
// & t2 -->  concurrently
// t1 & t2 --> parallel

// CAS  -> Compare and set operation 2                                                                                                                                                                                                                                                                                                                 