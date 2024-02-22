package wrap.multithreading.runnables;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableApp {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Integer> ids = Arrays.asList(1,2,5,6,8,7);
        process(executorService, ids);
    }

    private static void process(ExecutorService executorService, List<Integer> ids) {
        for(Integer id: ids){
            Runnable task = new RunnableWorker(id);
            executorService.submit(task);
        }
        executorService.shutdown();
    }
}
