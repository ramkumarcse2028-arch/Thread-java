class MyThreadRunnable implements Runnable{
    public void run(){
        int i = 0;
        while(i<=100)
            System.out.println("I am a thread not a thread ");
            i++;
    }
}
class MyThreadRunnable1 implements Runnable{
    public void run(){
        int i = 0;
        while(i<=100)
            System.out.println("I am a thread 1 not a thread 1 ");
            i++;
    }
}
public class thread1 {
    public static void main(String[] args) {
        MyThreadRunnable bullet = new MyThreadRunnable();
        Thread gun = new Thread(bullet);
        MyThreadRunnable1 bullet1 = new MyThreadRunnable1();
        Thread gun1 = new Thread(bullet1);
        gun.start();
        gun1.start();



    }
    
}
