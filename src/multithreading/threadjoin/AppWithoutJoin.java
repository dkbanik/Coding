package multithreading.threadjoin;

public class AppWithoutJoin {
    public static void main(String[] args) {
        Worker worker = new Worker();
        Thread t1 = new Thread(worker);
        Thread t2 = new Thread(worker);
        Thread t3 = new Thread(worker);
        System.out.println("Thread that started is: "+Thread.currentThread().getName());

        t1.start();
        t2.start();
        t3.start();
        // main thread doesnt wait for other threads to finish executing
        System.out.println("Thread ended: "+Thread.currentThread().getName());
    }
}
