package multithreading.multithreading;


import java.util.concurrent.Semaphore;

class SharedSemaphore{
    int counter = 1;
    int max = 100;
    Semaphore odd;
    Semaphore even;

    public SharedSemaphore() {
        this.odd = new Semaphore(1);
        this.even = new Semaphore(0);
    }

    public void printOdd() throws InterruptedException {
        while(counter < max){
            odd.acquire();
            if(counter%2 != 0){
                System.out.println("Thread "+Thread.currentThread().getName()+" printing "+ counter++);
                even.release();
                //Thread.sleep(1000);
            }
        }
    }

    public void printEven() throws InterruptedException {
        while(counter < max){
            even.acquire();
            if(counter%2 == 0){
                System.out.println("Thread "+Thread.currentThread().getName()+" printing "+ counter++);
                odd.release();
                //Thread.sleep(1000);
            }
        }
    }
}

class OddThreadSemaphore implements Runnable{
    SharedSemaphore sharedSemaphore;

    public OddThreadSemaphore(SharedSemaphore sharedSemaphore) {
        this.sharedSemaphore = sharedSemaphore;
    }

    @Override
    public void run() {
        try {
            sharedSemaphore.printOdd();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class EvenThreadSemaphore implements Runnable{
    SharedSemaphore sharedSemaphore;

    public EvenThreadSemaphore(SharedSemaphore sharedSemaphore) {
        this.sharedSemaphore = sharedSemaphore;
    }

    @Override
    public void run() {
        try {
            sharedSemaphore.printEven();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
public class ThreadPrb3Semaphore1 {
    public static void main(String[] args) {
        SharedSemaphore sharedSemaphore = new SharedSemaphore();
        Thread tA = new Thread(new EvenThreadSemaphore(sharedSemaphore));
        Thread tB = new Thread(new OddThreadSemaphore(sharedSemaphore));
        tA.start();
        tB.start();

        try {
            tA.join();
            tB.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
