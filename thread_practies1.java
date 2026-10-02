// Question -->   WAP to print "good morning " and "Welcome" continuously on the screen in java using threads
class practicel3 extends Thread{
    public void run(){
        while(true){
            System.out.println("Good morning");
        }
    }
}
class practicel3b extends Thread{
    public void run(){
        while(true){
            System.out.println("Welcome");
        }
    }
}
public class thread_practies1 {
    public static void main(String[] args) {
        practice13 p1 = new practice13();
        practicel3b p2 = new practicel3b();
        p1.start();
        p2.start();

    }
}
