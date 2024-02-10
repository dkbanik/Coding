package multithreading.multithreading;

class SharedNumbers{
    int counter=1;
    int max = 100;

    public synchronized void printOdd(){
        while (counter < max){
            while(counter%2 == 0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(counter+" ");
            counter++;
            notify();
        }
    }

    public synchronized void printEven(){
        while (counter < max){
            while(counter%2 != 0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(counter+" ");
            counter++;
            notify();
        }
    }
}

class OddThread implements Runnable{
    SharedNumbers sharedNumbers;

    public OddThread(SharedNumbers sharedNumbers) {
        this.sharedNumbers = sharedNumbers;
    }

    @Override
    public void run() {
        sharedNumbers.printOdd();
    }
}
class EvenThread implements Runnable{
    SharedNumbers sharedNumbers;

    public EvenThread(SharedNumbers sharedNumbers) {
        this.sharedNumbers = sharedNumbers;
    }

    @Override
    public void run() {
        sharedNumbers.printEven();
    }
}


public class ThreadPrb2 {
    public static void main(String[] args) {
        SharedNumbers sharedNumbers = new SharedNumbers();
        Thread t1 = new Thread(new OddThread(sharedNumbers));
        Thread t2 = new Thread(new EvenThread(sharedNumbers));
        t1.start();t2.start();
//        try {
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }
}
