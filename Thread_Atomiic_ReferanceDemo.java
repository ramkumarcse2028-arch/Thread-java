import java.util.concurrent.atomic.AtomicReference;

public class Thread_Atomiic_ReferanceDemo {
    public static void main(String[] args) {
        Likecounter   likeCounter = new Likecounter();

        // First Method
        /*Thread t1 = new Thread(()  -> likeCounter.like());
        Thread t2 = new Thread(()  -> likeCounter.like());
        Thread t3 = new Thread(()  -> likeCounter.like());
        Thread t4 = new Thread(()  -> likeCounter.like());
        Thread t5 = new Thread(()  -> likeCounter.like());
        Thread t6 = new Thread(()  -> likeCounter.like()); */

        Thread t1 = new Thread(()  -> {
            for(int i=1; i<=10; i++){
                likeCounter.like();
            }
        });

         Thread t2 = new Thread(()  -> {
            for(int i=1; i<=10; i++){
                likeCounter.like();
            }
        });

         Thread t3 = new Thread(()  -> {
            for(int i=1; i<=10; i++){
                likeCounter.like();
            }
        });
         Thread t4 = new Thread(()  -> {
            for(int i=1; i<=10; i++){
                likeCounter.like();
            }
        });

         Thread t5 = new Thread(()  -> {
            for(int i=1; i<=10; i++){
                likeCounter.like();
            }
        });

         Thread t6 = new Thread(()  -> {
            for(int i=1; i<=10; i++){
                likeCounter.like();
            }
        });

        // Second Method 
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

        try{
            Thread.sleep(2000);
        } catch(Exception e ){}
        System.out.println("Total like " + likeCounter.getTotalLikes());

    }
}
class Likecounter {
    AtomicReference<Integer> totalCount = new AtomicReference<>(0);
    public void like(){

    }
}
