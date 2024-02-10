package multithreading.multithreading;

public class Producer implements Runnable {
    SharedResource sharedResource;

    public Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        // i represent tasks
        for(int i=0;i<10;i++){
            sharedResource.produce(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

