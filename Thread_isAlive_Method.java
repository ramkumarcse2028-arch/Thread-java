public class Thread_isAlive_Method {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println(t1.isAlive());  // false

        t1.start();

        System.out.println(t1.isAlive());  // True

        try{
            Thread.sleep(3000);
        } catch(Exception e ){}

        System.out.println(t1.isAlive());  // false
        
    }
}


/* 
 isAlive() -->  start - terminate
 
 */