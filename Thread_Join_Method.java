public class Thread_Join_Method {
    public static void main(String[] args)  throws InterruptedException {
        System.out.println(" Main thread starts ");

        Thread t1 = new Thread(() -> {
            try{
                Thread.sleep(2000);
            } catch (InterruptedException e ){}

            System.out.println("Thread-0 starts ");
        });

        t1.start();

        t1.join(1000);  // let the t1 thread first complete its execution

        System.out.println(" Main thread ends ");
    }
}
 // join()
 /*
 Main thread  -> WAITING 
 t1 thread -> RUNNABLE ->  TERMINATED
 Main thread  -> WAITING -> RUNNABLE -> TERMINATED */
