import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;




public class Thread_poolExecutor {
    public static void main(String[] args) {
         ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,                  // core pool size
                5,                  // maximum pool size
                10,                 // keep alive time
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5)
        );

        for (int i = 1; i <= 5; i++) {
            int taskId = i;

            executor.execute(() -> {
                System.out.println(
                        "Task " + taskId + " is performed by "
                                + Thread.currentThread().getName()
                );

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
    }
}
