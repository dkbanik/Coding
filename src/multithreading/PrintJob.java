package multithreading;

public class PrintJob {
    public static void main(String[] args) {

        System.out.println("Application Started");
        Printer p = new Printer();
        Runnable firstWorker = new FirstWorker(p, "First Thread");
        Thread firstThread =  new Thread(firstWorker);


        Runnable secondWorker = new SecondWorker(p, "Second Thread");
        Thread secondThread = new Thread(secondWorker);

        firstThread.start();
        secondThread.start();

        System.out.println("Application Stopped");
    }
}
