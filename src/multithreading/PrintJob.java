package multithreading;

public class PrintJob {
    public static void main(String[] args) {

        System.out.println("Application Started");
        Printer p = new Printer();
        Runnable firstJob = new FirstThread(p, "First Thread");
        Thread firstThread =  new Thread(firstJob);


        Runnable secondJob = new SecondThread(p, "Second Thread");
        Thread secondThread = new Thread(secondJob);

        firstThread.start();
        secondThread.start();

        System.out.println("Application Stopped");
    }
}
