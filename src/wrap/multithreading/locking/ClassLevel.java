package wrap.multithreading.locking;
class Counter {
    private static int count = 0;

    public static void incrementShared() {
        synchronized (Counter.class) {
            System.out.println("Thread "+ Thread.currentThread().getName()+" incrementing counter");
            count++;
        }
    }

    public static int getCount() {
        return count;
    }
}
public class ClassLevel {
    public static void main(String[] args) {
        // Create and start two threads to increment the shared count
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {

                Counter.incrementShared();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                Counter.incrementShared();
            }
        });

        thread1.start();
        thread2.start();

        // Wait for threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the shared count
        System.out.println("Shared count: " + Counter.getCount());
    }
}

