package problems.lrucache;

import java.util.HashMap;

public class LRUCacheApp {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(new HashMap<>(), new DoublyLinkedList(), 5);
        cache.put("a", 2);
        cache.put("b",3);
        cache.printCache();

        cache.put("e",6);
        cache.get("b");
        cache.printCache();

        cache.put("f",8);
        cache.put("g",7);
        cache.get("a");
        cache.put("h", 10);

        cache.printCache();

    }
}
