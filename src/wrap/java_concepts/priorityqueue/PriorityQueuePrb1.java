package wrap.java_concepts.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueuePrb1 {
    public static void main(String[] args) {
        Queue<Double> queue1 = new PriorityQueue<>(Comparator.reverseOrder());
        queue1.add(10.0);
        queue1.add(5.0);
        queue1.add(15.0);
        System.out.println(queue1.poll());
        System.out.println(queue1.poll());
        System.out.println(queue1.poll());


    }
}
