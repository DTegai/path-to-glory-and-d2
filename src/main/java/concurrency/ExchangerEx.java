package concurrency;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * Exchanger is a synchonization point for two threads. With method exchange() thread take value
 * from exchanger and set another data.
 */
public class ExchangerEx {

    public static void main(String[] args) throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<>();
        
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                String value = exchanger.exchange("From another thread");
                System.out.println("Value from main: " + value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        
        String value = "Main";
        String valueFromThread = exchanger.exchange(value);
        System.out.println("Value from thread: " + valueFromThread);
    }

}
