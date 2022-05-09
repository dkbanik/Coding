package multithreading.printOddEven;

public class App {
    public static void main(String[] args) {
        PrintOddEven obj = new PrintOddEven(10);

        Thread t1 = new Thread(() -> obj.printEven(),"ThreadEven");

        Thread t2 = new Thread(() -> obj.printOdd(), "ThreadOdd");

        t1.start();
        t2.start();
    }
}
