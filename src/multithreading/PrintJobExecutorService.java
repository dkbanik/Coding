package multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class PrintJobExecutorService {
    public static void main(String[] args) {
        Printer p = new Printer();
        
        FirstWorker firstWorker = new FirstWorker(p, Thread.currentThread().getName());

        SecondWorker secondWorker = new SecondWorker(p, Thread.currentThread().getName());

        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(firstWorker);
        executor.execute(secondWorker);
    }
}
