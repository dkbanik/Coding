package multithreading;

import java.util.concurrent.Executors;
class MyRunnable implements Runnable{

    @Override
    public void run() {

    }
}
public class ExecutorService {


    public static void main(String[] args) {

        ExecutorService executorService = (ExecutorService) Executors.newFixedThreadPool(5);


    }
}
