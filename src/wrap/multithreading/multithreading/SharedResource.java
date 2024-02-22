package wrap.multithreading.multithreading;

import java.util.LinkedList;
import java.util.Queue;
class Producer implements Runnable {
    SharedResource sharedResource;

    public Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        // i represent tasks
        for(int i=0;i<10;i++){
            sharedResource.produce(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class Consumer implements Runnable {
    SharedResource sharedResource;

    public Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            sharedResource.consume();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
public class SharedResource {
    Queue<Integer> queue = new LinkedList<>();
    int capacity = 5;

    public synchronized void produce(int item){
        while(queue.size() == capacity){
            try {
                System.out.println("Queue is full. Producer is waiting...");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        queue.add(item);
        System.out.println("Item added : "+item);
        notify();
    }

    public synchronized void consume(){
        while (queue.isEmpty()){
            try {
                System.out.println("Queue is empty. Consumer is waiting");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Integer item = queue.poll();
        System.out.println("Item polled : "+item);
        notify();
    }

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
//        Thread t1 = new Thread(new Producer(sharedResource));
//        Thread t2 = new Thread(new Consumer(sharedResource));
//        t1.start();
//        t2.start();

        Thread t3 =  new Thread(() -> {
            int i=1;
            while(true){
                sharedResource.produce(i++);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t4 = new Thread(() -> {
            while(true){
                sharedResource.consume();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t3.start();
        t4.start();

        Thread t5 =  new Thread(() -> {
            for(int i=0;i<10;i++){
                sharedResource.produce(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t6 = new Thread(() -> {
            for(int i=0;i<10;i++){
                sharedResource.consume();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}

