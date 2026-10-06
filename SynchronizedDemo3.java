public class SynchronizedDemo3 {
    public static void main(String[] args) {
         Bank b1 = new Bank();
     

        Thread t1 = new Thread(() -> b1.deposit());
        Thread t2 = new Thread(() -> b1.withdraw());

        t1.start();
        t2.start();
    }
}

class Counter {
    static int count = 0;

    static void increment(){

  //  synchronized static void increment(){
        synchronized (Counter.class){
         try{
                 Thread.sleep(2000);
             } catch(Exception e){}

               count ++;
               System.out.println(count);
       }

    }
}