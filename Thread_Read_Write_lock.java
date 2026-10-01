import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.Lock;

public class Thread_Read_Write_lock {
    public static void main(String[] args) {
        SharedResource sr = new SharedResource();
        
         Thread r1 = new Thread(() -> sr.read());
         Thread r2 = new Thread(() -> sr.read());
         Thread r3 = new Thread(() -> sr.read());

        Thread w1 = new Thread(() -> sr.write(4));
        Thread w2 = new Thread(() -> sr.write(7));
        Thread w3 = new Thread(() -> sr.write(9));

        r1.start();
        r2.start();
        r3.start();

        w1.start();
        w2.start();
        w3.start();
    }
    
}
class SharedResource {
    private int value = 0;
    ReadWriteLock rwLock = new ReentrantReadWriteLock();
    Lock wl = rwLock.writeLock();  // Exclusive 
    Lock rl = rwLock.readLock();  // shared 

    public int read(){
        rl.lock();
          try{
            try{
                Thread.sleep(2000);
            } catch( Exception e ) {}
            System.out.println(Thread.currentThread().getName() + " exited ");
            return value;
        }
        finally{
            rl.unlock();
        }
    }
    
    public void write(int newValue){
        wl.lock();


        try{
            System.out.println(Thread.currentThread().getName() + " entered ");
            try{
                Thread.sleep(2000);
            } catch( Exception e ) {}
            value = newValue;
            System.out.println(Thread.currentThread().getName() + " exited ");
        }
        finally{
            wl.unlock();
        }
    }
    
}
