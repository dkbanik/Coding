package multithreading;

public class SecondWorker extends ThreadJob implements Runnable{

    public SecondWorker(Printer p, String threadName) {
        super(p, threadName);
    }
}
