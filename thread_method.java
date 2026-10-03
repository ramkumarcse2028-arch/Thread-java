class MyNewThr1 extends Thread {
    public void run() {
        int i = 0;
        while (true) {
            System.out.println("Thank you");
            try {
                Thread.sleep(455);   // Correct way to use sleep
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }
}

class MyNewThr2 extends Thread {   // Thread (capital T)
    public void run() {
        while (true) {
            System.out.println("My thank you");
        }
    }
}

public class thread_method {
    public static void main(String[] args) {
        MyNewThr1 t1 = new MyNewThr1();
        MyNewThr2 t2 = new MyNewThr2();  // Correct class name

        t1.start();

        try {
            t1.join();   // Main waits for t1 to finish
        } catch (Exception e) {
            System.out.println(e);
        }

        t2.start();
    }
}



 