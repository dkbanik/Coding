package wrap.multithreading.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExmpleOne {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 5,
                                                             TimeUnit.MINUTES,new ArrayBlockingQueue<>(2),
                                                             new CustomThreadFactory(), new CustomRejectPolicy());
        for(int i=0;i<8;i++) {
            executor.submit(() -> {
                System.out.println("Processing task by thread " + Thread.currentThread().getName());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            });
        }
        executor.shutdown();
    }


}
class CustomThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        Thread th = new Thread(r);
        th.setPriority(Thread.NORM_PRIORITY);
        return th;
    }
}

class CustomRejectPolicy implements RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(" Rejected task: "+r.toString());
    }
}
