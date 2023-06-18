package multithreading.printOddEven;

public class App {
    public static void main(String[] args) {
        PrintOddEven obj = new PrintOddEven(10);

        Thread t1 = new Thread(() -> obj.printEven(),"ThreadEven");

        Thread t2 = new Thread(() -> obj.printOdd(), "ThreadOdd");

//        Thread t3 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                obj.printOdd();
//            }
//        }, "thread3");

        t1.start();
        t2.start();
    }
}
