package wrap.multithreading.multithreading;

import java.util.LinkedList;
import java.util.Queue;

class ProducerWorker implements Runnable{
    SharedResource sharedResource;

    public ProducerWorker(SharedResource sharedResource){this.sharedResource = sharedResource;}
    @Override
    public void run() {
        // no of items to produce
        for(int i=0;i<10;i++) {
            // this is shared resource that we are locking
            synchronized (sharedResource){
                Queue<Integer> queue = sharedResource.queue;
                while (queue.size() == sharedResource.capacity) {
                    try {
                        System.out.println("Queue is full. Producer is waiting...");
                        // Thread should wait and let consumer thread to consume n notify
                        sharedResource.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                queue.add(i);
                System.out.println("Item added : " + i);
                // notifying consumer thread to wake up
                sharedResource.notify();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ConsumerWorker implements Runnable{
    SharedResource sharedResource;
    public ConsumerWorker(SharedResource sharedResource){this.sharedResource = sharedResource;}

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            synchronized (sharedResource) {
                Queue<Integer> queue = sharedResource.queue;

                while (queue.isEmpty()) {
                    try {
                        System.out.println("Queue is empty. Consumer is waiting");
                        sharedResource.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                Integer item = queue.poll();
                System.out.println("Item polled : " + item);

                sharedResource.notify();
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
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

        Thread producerWorker = new Thread(new ProducerWorker(sharedResource));
        Thread consumerWorker = new Thread(new ConsumerWorker(sharedResource));

        producerWorker.start();consumerWorker.start();

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

        //t3.start();
        //t4.start();

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

