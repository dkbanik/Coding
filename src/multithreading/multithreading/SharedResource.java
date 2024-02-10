package multithreading.multithreading;

import java.util.LinkedList;
import java.util.Queue;

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
        Thread t1 = new Thread(new Producer(sharedResource));
        Thread t2 = new Thread(new Consumer(sharedResource));
        t1.start();
        t2.start();
    }
}

