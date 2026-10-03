public class Thread_lifeCycle {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();

         Thread t1 = new Thread(() -> {
            System.out.println("Name of current thread is: " + Thread.currentThread().getName());

            System.out.println("Main thread state: " + mainThread.getState());
        });
         System.out.println("Before start: " + t1.getState());

        // RUNNABLE state
        t1.start();

        System.out.println("After start: " + t1.getState());  // RUNNABLE 


        try{
            Thread.sleep(2000);
        } catch ( Exception e ){
             e.printStackTrace();
        }

        System.out.println(t1.getState());

    
    }
}

    










