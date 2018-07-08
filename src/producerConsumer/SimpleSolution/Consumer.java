package producerConsumer.SimpleSolution;

/**
 * Created by sachin on 3/6/18.
 */
public class Consumer implements Runnable{

    private BufferStorage storage;
    public Consumer(BufferStorage storage){
        this.storage=storage;
    }

    @Override
    public void run() {

        for (int i=0; i<100; i++){
            storage.removeItem();
        }

    }
}
