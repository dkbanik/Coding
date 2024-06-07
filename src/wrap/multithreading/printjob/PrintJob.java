package wrap.multithreading.printjob;

public class PrintJob {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Application Started");
        // printer is common
        // 2 threads running on same printer
        // each thread when uses the printer completes all printing then next thread uses it
        Printer p = new Printer();
        Runnable firstWorker = new FirstWorker(p, "First Thread");
        Thread firstThread =  new Thread(firstWorker);


        Runnable secondWorker = new SecondWorker(p, "Second Thread");
        Thread secondThread = new Thread(secondWorker);

        firstThread.start();
        secondThread.start();

        firstThread.join();secondThread.join();
        System.out.println("Application Stopped");
    }
}
