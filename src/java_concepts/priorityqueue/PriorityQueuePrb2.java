package java_concepts.priorityqueue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueuePrb2 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A",15);
        map.put("B",5);
        map.put("C",10);

        Queue<Map.Entry<String, Integer>> entryQueue = new PriorityQueue<>(Comparator.comparingInt(entry -> -entry.getValue()));
        entryQueue.addAll(map.entrySet());
        System.out.println(entryQueue.poll());
        System.out.println(entryQueue.poll());
        System.out.println(entryQueue.poll());

    }
}
