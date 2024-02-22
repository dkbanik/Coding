package wrap.multithreading.multithreading;
class SharedString{
    String str = "DEB";
    int index=0;
    public synchronized void print(int id){
        int len = str.length();
        for(int i=0;i<3;i++){
            while(index % len != id){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            char ch = str.charAt(index%len);
            System.out.print(ch);
            index++;
            notifyAll();
        }
    }

}
class ThreadPrinter implements Runnable{
    int id;
    SharedString sharedString;
    public ThreadPrinter(int id, SharedString sharedString) {
        this.id = id;
        this.sharedString = sharedString;
    }
    @Override
    public void run() {
        sharedString.print(id);
    }
}
public class ThreadPrb1 {
    public static void main(String[] args) {
        SharedString sharedString = new SharedString();
        Thread t1 = new Thread(new ThreadPrinter(0, sharedString));
        Thread t2 = new Thread(new ThreadPrinter(1, sharedString));
        Thread t3 = new Thread(new ThreadPrinter(2, sharedString));

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
