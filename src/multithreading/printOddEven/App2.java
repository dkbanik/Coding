package multithreading.printOddEven;

public class App2 {
    public static void main(String[] args) {
        Number num = new Number(0,10);
        Thread t1 = new Thread(new OddNumberWorker(num));
        Thread t2 = new Thread(new EvenNumberWorker(num));

        t1.start();
        t2.start();
    }
}
