package multithreading.multithreading;

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
            for (int i = 1; i <= 5; i++) {
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
            for (int i = 1; i <= 5; i++) {
                // Consume an item from the queue
                int item = blockingQueue.take();
                System.out.println("Consumed: " + item);

                // Simulate some processing time
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class BlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();

        // Create producer and consumer threads
        Thread producerThread = new Thread(new ProducerBlocking(blockingQueue));
        Thread consumerThread = new Thread(new ConsumerBlocking(blockingQueue));

        // Start the threads
        producerThread.start();
        consumerThread.start();
    }
}

