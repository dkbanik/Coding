package wrap.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.Thread.currentThread;

class MyCallable implements Callable<String> {
    int start;

    MyCallable(int start) {
        this.start = start;
    }

    @Override
    public String call() {
        System.out.println(currentThread().getName() + " running");
        System.out.println();
        for (int i = start; i < start + 20; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        return currentThread().getName();
    }
}

public class MyExecutorService {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<MyCallable> myCallableList = new ArrayList<>();
        List<Future<String>> futures = new ArrayList<>();
        int start = 1;
        for (int i = 1; i <= 5; i++) {
            myCallableList.add(new MyCallable(start));
            start+=20;
        }
        try {
            futures = executorService.invokeAll(myCallableList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();

        for(Future<String> future : futures){
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
