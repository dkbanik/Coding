package wrap.multithreading.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class ProducerBlocking implements Runnable {
    private final BlockingQueue<Integer> blockingQueue;

    public ProducerBlocking(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                if(blockingQueue.size() == 5){
                    System.out.println("producer is full...waiting for consumer to consume");
                }
                // Produce an item and add it to the queue
                blockingQueue.put(i);
                System.out.println("Produced: " + i);

                // Simulate some processing time
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class ConsumerBlocking implements Runnable {
    private final BlockingQueue<Integer> blockingQueue;

    public ConsumerBlocking(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                if(blockingQueue.isEmpty()){
                    System.out.println("consumer is empty ..waiting for producer to produce");
                }
                // Consume an item from the queue
                int item = blockingQueue.take();
                System.out.println("Consumed: " + item);

                // Simulate some processing time
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class BlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(5);

        // Create producer and consumer threads
        Thread producerThread = new Thread(new ProducerBlocking(blockingQueue));
        Thread consumerThread = new Thread(new ConsumerBlocking(blockingQueue));

        // Start the threads
//        producerThread.start();
//        consumerThread.start();


        Thread p1 = new Thread(() -> {
            int i=0;
            while(true){
                if(blockingQueue.size() == 5){
                    System.out.println("Queue is full..waiting for consumer to consume");
                }
                i++;
                try {
                    blockingQueue.put(i);
                    System.out.println("Producer produced "+i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread c1 = new Thread(() ->  {
            while(true){
                if(blockingQueue.isEmpty()){
                    System.out.println("Queue is empty..waiting for producer to produce");
                }
                try{
                    Integer i = blockingQueue.take();
                    System.out.println("Consumed "+i);
                    Thread.sleep(5000);
                }catch (InterruptedException ie){
                    throw new RuntimeException(ie);
                }
            }
        });

        p1.start();
        c1.start();
    }
}

