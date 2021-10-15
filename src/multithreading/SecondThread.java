package multithreading;

public class SecondThread extends ThreadJob implements Runnable{

    public SecondThread(Printer p, String threadName) {
        super(p, threadName);
    }
}
