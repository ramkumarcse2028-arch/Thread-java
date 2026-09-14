public class Thread_communicationDemo {
    public static void main(String[] args) {
        Box box = new Box();

        Thread t1 = new Thread(() -> {
            for(int i = 1; i<=20; i++){
                try{
                    Thread.sleep(100);
                } catch( Exception e){}
                box.producer(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 1; i<=20; i++){
                try{
                    Thread.sleep(100);
                } catch( Exception e){}
                box.consumer();
            }
        });

        t1.start();
        t2.start();
    }
}
class Box {
    volatile Integer item;
    volatile Boolean flag = false;

    void producer(int value){
        while(flag == true ){
            // do nothing 
        }
        item = value;
        flag = true;
        System.out.println("Producer produces " + item );
    }

    void consumer(){
        while(flag == false){
            // do nothing 
        }
        System.out.println("Consumer consumes " + item );
        item = null;
        flag = false;
    }
}

