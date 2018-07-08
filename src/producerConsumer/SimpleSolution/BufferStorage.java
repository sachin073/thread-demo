package producerConsumer.SimpleSolution;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sachin on 3/6/18.
 */
public class BufferStorage {

    List<Date> storage = new ArrayList<>();
    int maxSize;
    BufferStorage(int maxSize){
        this.maxSize =maxSize;
    }



    public void addItem(){
        synchronized (storage){
            System.out.println(Thread.currentThread().getName()+" try adding item");

            while (storage.size() == maxSize){
                try {
                    System.out.println(Thread.currentThread().getName()+" wait for adding item");
                    storage.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            storage.add(new Date());
            System.out.printf("Set: %d",storage.size());
            System.out.println(Thread.currentThread().getName()+" added item");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            storage.notifyAll();
        }
    }


    public void removeItem(){
        synchronized (storage){
            System.out.println(Thread.currentThread().getName()+" try removing item");
            while (storage.size() == 0){
                try {
                    System.out.println(Thread.currentThread().getName()+" waiting for items");
                    storage.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            storage.remove(0);
            System.out.printf(" removing: %d",storage.size());
            System.out.println(Thread.currentThread().getName()+" removed and gone");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            storage.notifyAll();
        }
    }



}
