package multithreading.threadjoin;

public class AppWithJoin {
    public static void main(String[] args) {
        Worker worker = new Worker();
        Thread t1 = new Thread(worker);
        Thread t2 = new Thread(worker);
        Thread t3 = new Thread(worker);
        System.out.println("Thread that started is: "+Thread.currentThread().getName());

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // main thread waits for other threads to finish executing, then it finishes its execution.
        System.out.println("Thread ended: "+Thread.currentThread().getName());
    }
}
