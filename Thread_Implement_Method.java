public class Thread_Implement_Method {
    public static void main(String[] args) {
        System.out.println(" Main thread starting ");

        try {
        Thread.sleep(2000);
    } catch (InterruptedException e){}
        System.out.println(" Main thread ends ");
    
    }
    
    
}

// Thread implement method
/* 
Thread.sleep(milliseconds) -> TIMED_WAITING 
RUNNABLE  -> TIMED_WAITING -> RUNNABLE   */