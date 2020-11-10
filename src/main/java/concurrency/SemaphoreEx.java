package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreEx {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(3);
        
        Runnable car = () -> {
            String threadName = Thread.currentThread().getName();
            try {
                semaphore.acquire();
                System.out.println("Go on parking [" + threadName + "]");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("Go out [" + threadName + "]");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        
        executorService.submit(car);
        executorService.submit(car);
        executorService.submit(car);
        executorService.submit(car);
        executorService.submit(car);
        executorService.submit(car);
        executorService.submit(car);
        
        executorService.shutdown();
    }
}
