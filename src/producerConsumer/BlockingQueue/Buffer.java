package producerConsumer.BlockingQueue;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by sachin on 24/7/18.
 */
public class Buffer {

    final LinkedBlockingDeque<String> queue = new LinkedBlockingDeque<String>(11);


    public static void main(String[] args) {

new Buffer().called();
        System.out.println("returned");
    }


     void called(){
        Buffer buffer = new Buffer();

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {Thread.sleep(1000);
                        buffer.queue.put("added"+i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("added"+i);
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        System.out.println("removed "+ buffer.queue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        producer.start();
        consumer.start();

       /* try {
            System.out.println(" waiting for ending");
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}
