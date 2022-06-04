package multithreading.printOddEven;

public class EvenNumberWorker implements Runnable{
    Number number;

    public EvenNumberWorker(Number number) {
        this.number = number;
    }

    @Override
    public void run() {
        synchronized (number){
            while (number.getNumber() < number.getCapacity()){
                while (number.getNumber() % 2 != 0){
                    try {
                        number.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Even Thread executing.."+number.getNumber());
                number.setNumber(number.getNumber()+1);
                number.notify();
            }
        }

    }
}
