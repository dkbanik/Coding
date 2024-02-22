package wrap.multithreading.multithreading;

public class ThreadExample {
    public static void main(String[] args) {
        Thread t1 = new Thread( () -> {
            System.out.println("thread 1 running");
        });
        t1.start();
    }
}
