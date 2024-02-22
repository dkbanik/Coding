package wrap.multithreading;

import java.util.concurrent.Semaphore;

class Shared{
    static int count = 0;
}

class MyRunnable implements Runnable{
    Semaphore sem;
    String name;

    public MyRunnable(Semaphore sem, String name) {
        this.sem = sem;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Starting thread "+this.name);
        if(this.name.equals("A")) {
            try {
                System.out.println("Thread " + this.name + " acquiring semaphore");
                sem.acquire();

                for (int i = 0; i < 5; i++) {
                    System.out.println("Count " + ++Shared.count);
                    Thread.sleep(10);
                }
                System.out.println("Thread " + this.name + " releasing semaphore");
                sem.release();
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("Thread "+this.name+ " acquiring semaphore");
            try {
                sem.acquire();

                for (int i=0;i<5;i++){
                    System.out.println("Count "+ --Shared.count);
                    Thread.sleep(10);
                }
                System.out.println("Thread "+this.name+ " releasing semaphore");
                sem.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class SemaphoreApp {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);
        Thread tA = new Thread(new MyRunnable(sem, "A"));
        Thread tB = new Thread(new MyRunnable(sem, "B"));
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
