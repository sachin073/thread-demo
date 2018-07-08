package producerConsumer.SimpleSolution;

/**
 * Created by sachin on 3/6/18.
 */
public class Producer implements Runnable{

    private BufferStorage storage;
    public Producer(BufferStorage storage){
        this.storage=storage;
    }

    @Override
    public void run() {
        for (int i=0; i<100; i++){
            storage.addItem();
        }
    }
}
