package multithreading;

public class FirstThread extends ThreadJob implements Runnable{

    public FirstThread(Printer p, String threadName) {
        super(p, threadName);
    }
}
