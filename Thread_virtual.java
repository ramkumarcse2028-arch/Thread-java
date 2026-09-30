import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thread_virtual {
    public static void main(String[] args) {
        /*Thread t1 = Thread.startVirtualThread(()  -> {
            System.out.println(Thread.currentThread() + " says Hello ");
        });
      
        try{
            t1.join();
        }
        catch(Exception e) {} */

        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        for(int i=1; i<=5; i++){
            executor.submit(()  -> {
                System.out.println("Task executed by " + Thread.currentThread());
            });
            try{
                Thread.sleep(2000);
            }
            catch(Exception e){}

        }
        executor.shutdown();
    }
}
