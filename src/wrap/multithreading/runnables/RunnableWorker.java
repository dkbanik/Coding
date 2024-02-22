package wrap.multithreading.runnables;

import java.util.Random;

public class RunnableWorker implements Runnable{

    int id;

    public RunnableWorker(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        Random random = new Random();
        int randNum = random.nextInt(9000)+1000;
        try {
            Thread.sleep(randNum);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread "+ Thread.currentThread().getName()+" processing "+id);

    }
}
