package multithreading;

public class StartVsRun extends Thread{

    public void run(){
        System.out.println("Thread "+currentThread().getName()+ " started");
    }

    public static void main(String[] args) {
        StartVsRun app1 = new StartVsRun();
        StartVsRun app2 = new StartVsRun();
        app1.start();
        app2.run();

    }
}
