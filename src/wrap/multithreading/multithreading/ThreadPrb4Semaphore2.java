package wrap.multithreading.multithreading;

import java.util.concurrent.Semaphore;

class SharedStringSemaphore{
    Semaphore d,e,b;

    public SharedStringSemaphore() {
        d = new Semaphore(1);
        e = new Semaphore(0);
        b = new Semaphore(0);
    }

    public void printD() throws InterruptedException {
        d.acquire();
        System.out.println("Thread "+Thread.currentThread().getName()+ "printing "+ "D");
        Thread.sleep(1000);
        e.release();
    }
    public void printE() throws InterruptedException {
        e.acquire();
        System.out.println("Thread "+Thread.currentThread().getName()+ "printing "+ "E");
        Thread.sleep(1000);
        b.release();
    }
    public void printB() throws InterruptedException {
        b.acquire();
        System.out.println("Thread "+Thread.currentThread().getName()+ "printing "+ "B");
        Thread.sleep(1000);
        d.release();
    }
}

class PrintD implements Runnable{
    SharedStringSemaphore sharedStringSemaphore;
    int n;

    public PrintD(SharedStringSemaphore sharedStringSemaphore, int n) {
        this.sharedStringSemaphore = sharedStringSemaphore;
        this.n=n;
    }

    @Override
    public void run() {
        for(int i=1;i<=n;i++){
            try {
                sharedStringSemaphore.printD();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class PrintB implements Runnable{
    SharedStringSemaphore sharedStringSemaphore;
    int n;

    public PrintB(SharedStringSemaphore sharedStringSemaphore, int n) {
        this.sharedStringSemaphore = sharedStringSemaphore;
        this.n=n;
    }

    @Override
    public void run() {
        for(int i=1;i<=n;i++){
            try {
                sharedStringSemaphore.printB();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class PrintE implements Runnable{
    SharedStringSemaphore sharedStringSemaphore;
    int n;

    public PrintE(SharedStringSemaphore sharedStringSemaphore, int n) {
        this.sharedStringSemaphore = sharedStringSemaphore;
        this.n=n;
    }

    @Override
    public void run() {
        for(int i=1;i<=n;i++){
            try {
                sharedStringSemaphore.printE();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class ThreadPrb4Semaphore2 {
    public static void main(String[] args) {
        SharedStringSemaphore sss = new SharedStringSemaphore();
        int n=3;
        Thread tA = new Thread(new PrintD(sss,3));
        Thread tB = new Thread(new PrintE(sss,3));
        Thread tC = new Thread(new PrintB(sss,3));

//        tA.start();tB.start();tC.start();
//
//
//        try {
//            tA.join();tB.join();
//            tC.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        Thread d = new Thread(() -> {
            for(int i=0;i<n;i++){
                try {
                    sss.printD();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread e = new Thread(() -> {
            for(int i=0;i<n;i++){
                try {
                    sss.printE();
                } catch (InterruptedException ie) {
                    throw new RuntimeException(ie);
                }
            }
        });
        Thread b = new Thread(() -> {
            for(int i=0;i<n;i++){
                try {
                    sss.printB();
                } catch (InterruptedException e2) {
                    throw new RuntimeException(e2);
                }
            }
        });
        d.start();e.start();b.start();
    }
}
