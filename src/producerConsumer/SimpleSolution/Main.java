package producerConsumer.SimpleSolution;

/**
 * Created by sachin on 3/6/18.
 */
public class Main {

    public static void main(String[] args) {

        BufferStorage bufferStorage = new BufferStorage(5);
        Producer producer = new Producer(bufferStorage);
        Consumer consumer= new Consumer(bufferStorage);

        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();

    }
}
