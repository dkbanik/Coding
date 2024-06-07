package wrap.multithreading.locking;
class Counter {
    private static int count = 0;

    public void incrementObjectShared() {
        synchronized (this) {
            System.out.println("Object Thread "+ Thread.currentThread().getName()+" incrementing counter");
            count++;
        }
    }

    public void decrementObjectShared(){
        synchronized (this){
            System.out.println("Object Thread "+ Thread.currentThread().getName()+" decrementing counter");
            count--;
        }
    }

    public static void incrementShared() {
        synchronized (Counter.class) {
            System.out.println("Thread "+ Thread.currentThread().getName()+" incrementing counter");
            count++;
        }
    }

    public static void decrementShared(){
        synchronized (Counter.class){
            System.out.println("Thread "+ Thread.currentThread().getName()+" decrementing counter");
            count--;
        }
    }

    public static int getCount() {
        return count;
    }
}
public class ClassLevel {
    public static void main(String[] args) {
        classLevelLocking();
        //objectLevelLocking();
    }


    // here any one of the thread can lock the object method and work on it, & other thread can lock other method
    // o/p, we can see for some time t1 will be running, some other time t2, again t1,
    // in no order
    public static void objectLevelLocking(){
        Counter counter = new Counter();
        Thread t1 = new Thread( () -> {
            for (int i=0;i<10;i++){
                counter.incrementObjectShared();
            }
        });

        Thread t2 = new Thread( () -> {
            for (int i=0;i<10;i++){
                counter.decrementObjectShared();
            }
        });

        t1.start();
        t2.start();

        // Wait for threads to finish
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the shared count
        System.out.println("Shared count: " + Counter.getCount());
    }


    // here, once a thread locks the class, then it will not allow other thread to execute any other method in the class
    // so o/p will be t1 running all, then t2 will run rest
    public static void classLevelLocking(){
        // Create and start two threads to increment the shared count
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {

                Counter.incrementShared();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                Counter.decrementShared();
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

