public class Thread_wait_notify {
    public static void main(String[] args) {
        Box box = new Box();

        Thread t1 = new Thread(() -> {
            for(int i = 1; i<=20; i++){
                try{
                    Thread.sleep(100);
                     box.producer(i);
                } catch( Exception e){}
            
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 1; i<=20; i++){
                try{
                    Thread.sleep(100);
                     box.consumer();
                } catch( Exception e){}
            
            }
        });

        t1.start();
        t2.start();
    }
}
class Box {
    volatile Integer item;
    volatile Boolean flag = false;

    synchronized void producer(int value) throws InterruptedException {
        while(flag == true ){
            wait();
        }
        item = value;
        flag = true;
        System.out.println("Producer produces " + item );
        notify();
    }

    synchronized  void consumer() throws InterruptedException {
        while(flag == false){
            wait();
        }
        System.out.println("Consumer consumes " + item );
        item = null;
        flag = false;
        notify();
    }
}
