package wrap.multithreading.printOddEven;

public class OddNumberWorker implements Runnable{
    Number number;

    OddNumberWorker(Number number){
        this.number = number;
    }
    @Override
    public void run() {
        synchronized (number){
            while (number.getNumber() < number.getCapacity()){
                while (number.getNumber() % 2 == 0){
                    try {
                        number.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Odd Thread executing.."+number.getNumber());
                number.setNumber(number.getNumber()+1);

                number.notify();
            }
        }

    }
}
