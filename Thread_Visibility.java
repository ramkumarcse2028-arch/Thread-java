public class Thread_Visibility {
    static boolean flag = false;
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try{
                Thread.sleep(1000);
            } catch (Exception e)  {}
            flag = true;  // cache  -->  flag = true 
        });

        Thread t2 = new Thread(() -> {  // cache  -> flag = false
            while(!flag){}
           /*  try{
                Thread.sleep(1000);
            } catch (Exception e)  {
                System.out.println("thread 2 running  ");
            } */

            System.out.println("Thread 2 finish ");
        });
         t1.start();
         t2.start();

    }
}
