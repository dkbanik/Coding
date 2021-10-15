package multithreading;

public class ThreadJob implements Runnable{

    Printer p;
    String threadName;

    public ThreadJob(Printer p, String threadName) {
        this.p = p;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        p.printDocuments(10,threadName);
    }
}
