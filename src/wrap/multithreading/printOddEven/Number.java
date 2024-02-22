package wrap.multithreading.printOddEven;

public class Number {
    int number;
    final int capacity;

    public Number(int number, int capacity) {
        this.number = number;
        this.capacity = capacity;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }
}
