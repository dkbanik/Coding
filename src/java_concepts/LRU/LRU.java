package java_concepts.LRU;


import java.util.HashMap;
import java.util.Map;

public class LRU {

    LRUNode head = new LRUNode(0,"");
    LRUNode tail = new LRUNode(0,"");
    Map<Integer, LRUNode> cache;
    int capacity;

    LRU(int capacity){
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>();
    }

    public void put(int key, String value){
        LRUNode node = new LRUNode(key, value);
        // if cache full, remove last node from cache and delete the node
        if(cache.size() == capacity){
            cache.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        insertNode(node);
        cache.put(key, node);
    }

    public String get(int key){
        LRUNode node = cache.get(key);
        if(node != null){
            deleteNode(node);
            insertNode(node);
            return node.value;
        }
        return "not found";
    }

    public void insertNode(LRUNode node){
        node.next = head.next;
        head.next = node;
        node.prev = head;
        node.next.prev = node;
    }

    public void deleteNode(LRUNode node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public static void main(String[] args) {
        LRU lruCache = new LRU(3);
        lruCache.put(1, "abc");
        lruCache.put(2, "def");
        lruCache.put(3, "kdg");
        lruCache.put(4, "bash");
        System.out.println(lruCache);

        System.out.println(lruCache.get(1)); // not found
        System.out.println(lruCache);

        System.out.println(lruCache.get(4)); // bash
        System.out.println(lruCache);

        lruCache.put(1, "cbf");
        System.out.println(lruCache);

        System.out.println(lruCache.get(4)); // bash
        System.out.println(lruCache);

        System.out.println(lruCache.get(2)); // not found
        System.out.println(lruCache);


    }

    @Override
    public String toString() {
        return "LRU{" +
                "cache=" + cache +
                '}';
    }
}
class LRUNode{
    int key;
    String value;
    LRUNode next, prev;

    LRUNode(int key, String value){
        this.key=key;
        this.value=value;
    }

    @Override
    public String toString() {
        return "LRUNode{" +
                "key=" + key +
                ", value='" + value + '\'' +
                '}';
    }
}

