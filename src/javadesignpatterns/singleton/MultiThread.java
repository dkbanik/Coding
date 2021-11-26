package javadesignpatterns.singleton;

public class MultiThread {
    public static void main(String[] args) {
        Thread firstThread = new Thread(new FirstThread());
        Thread secThread = new Thread(new SecondThread());

        firstThread.start();
        secThread.start();
    }


}
