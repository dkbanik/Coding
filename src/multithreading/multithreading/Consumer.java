package multithreading.multithreading;

public class Consumer implements Runnable {
    SharedResource sharedResource;

    public Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            sharedResource.consume();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
