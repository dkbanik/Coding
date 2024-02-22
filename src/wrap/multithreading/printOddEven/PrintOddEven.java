package wrap.multithreading.printOddEven;

public class PrintOddEven {

    int counter = 1;
    int size;

    PrintOddEven(int size){
        this.size = size;
    }

    public void printOdd(){
        synchronized (this){
            while(counter < size){
                while(counter%2 == 0){
                    try {
                        wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+": " + counter);
                counter++;
                notify();
            }
        }
    }

    public void printEven(){
        synchronized (this){
            while(counter < size){
                while(counter%2 != 0){
                    try {
                        wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+": "+counter);
                counter++;
                notify();
            }
        }
    }
}
