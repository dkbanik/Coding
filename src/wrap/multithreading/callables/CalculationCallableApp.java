package wrap.multithreading.callables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CalculationCallable implements Callable<Integer> {

    int id;

    public CalculationCallable(int id) {
        this.id = id;
    }

    public Integer call(){
        Random random = new Random();
        int randNum = random.nextInt(9000)+1000;
        try {
            Thread.sleep(randNum);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(" Thread "+Thread.currentThread().getName() + " calculation "+id*5);
        return id*5;
    }
}

public class CalculationCallableApp{
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Integer> ids = Arrays.asList(2,4,14,6,8,10);
        List<Integer> results = process(executorService, ids);
        for(Integer response : results){
            System.out.println(response);
        }
    }

    private static List<Integer> process(ExecutorService executorService, List<Integer> ids) {
        List<Integer> result = new ArrayList<>();
        List<Future<Integer>> futures = new ArrayList<>();
        for(Integer id: ids){
            Callable<Integer> task = new CalculationCallable(id);
            futures.add(executorService.submit(task));
        }

        executorService.shutdown();

        for(Future<Integer> future : futures){
            try {
                result.add(future.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }


}
