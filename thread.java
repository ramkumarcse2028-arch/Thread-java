class MyThread extends Thread{
    @Override
    public void run(){
        int i = 0;
        while(i<100){
            System.out.println("My cooking Thread is runnig");
            System.out.println("I am happy");
            i++;
        }
    }
}
class MyThread1 extends Thread{
    @Override
    public void run(){
        int i = 0;
        while(i<100){
            System.out.println("Thread 1 for chatting with her");
            System.out.println("I am sad");
            i++;
        }
    }
}
public class thread {
    public static void main (String[] args){
        MyThread t = new MyThread();
        MyThread1 t1 = new MyThread1();
        t.start();
        t1.start();
    }
    
}
