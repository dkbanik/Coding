package wrap.multithreading.printjob;

public class FirstWorker extends ThreadJob implements Runnable{

    public FirstWorker(Printer p, String threadName) {
        super(p, threadName);
    }
}
