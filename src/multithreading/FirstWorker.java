package multithreading;

public class FirstWorker extends ThreadJob implements Runnable{

    public FirstWorker(Printer p, String threadName) {
        super(p, threadName);
    }
}
