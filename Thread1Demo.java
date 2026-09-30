public class Thread1Demo {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getId());

        Thread t1 = new Thread(() -> {
            System.out.println("Name of my thread is " + Thread.currentThread().getName());
            System.out.println("Name of my thread is " + Thread.currentThread().getId());
        });

        
        Thread t2 = new Thread(() -> {
            System.out.println("Name of my 2nd thread is " + Thread.currentThread().getName());
            System.out.println("Name of my 2nd  thread is " + Thread.currentThread().getId());
        });
       // t1.run();
       // t2.run();

        t1.start();
        t2.start();
    }
}
