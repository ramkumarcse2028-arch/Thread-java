import java.util.concurrent.locks.StampedLock;
public class Thread_TryOptimisticRead {


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

    private final StampedLock lock = new StampedLock();

    public int read() {

        long stamp = lock.tryOptimisticRead();

        int currentValue = value;

        if (!lock.validate(stamp)) {

            stamp = lock.readLock();

            try {
                currentValue = value;
            } finally {
                lock.unlockRead(stamp);
            }
        }

        System.out.println(
                Thread.currentThread().getName()
                + " read value = " + currentValue);

        return currentValue;
    }

    public void write(int newValue) {

        long stamp = lock.writeLock();

        try {

            Thread.sleep(2000);

            value = newValue;

            System.out.println(
                    Thread.currentThread().getName()
                    + " changed value to " + value);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlockWrite(stamp);
        }
    }
}