package wrap.problems.lrucache;

import java.util.Map;

public class LRUCache {
    Map<String, DoublyLLNode> map;
    DoublyLinkedList deque;
    int capacity;

    public LRUCache(Map<String, DoublyLLNode> map, DoublyLinkedList deque, int capacity) {
        this.map = map;
        this.deque = deque;
        this.capacity = capacity;
    }

    public void put(String key, int value){
        DoublyLLNode head;
        if(map.containsKey(key)){
            // fetch the node from the map and replace it to the front of the deque
            head = deque.replaceNodeToFront(map.get(key));
        }else{
            // fresh value needs to be inserted,
            // add to deque and map it to hashmap
            head = deque.add(new DoublyLLNode(value));

            // Also check if size of deque exceeded the cache capacity
            if(deque.getSize() > this.capacity){
                deque.eject();
            }
        }
        map.put(key, head);
    }

    public int get(String key){
        DoublyLLNode node = map.get(key);
        DoublyLLNode head;
        int value;
        if (node != null){
            value= node.value;
            head = deque.replaceNodeToFront(node);
            map.put(key, head);
        }else{
            value = -1;
        }
        return value;
    }

    public void printCache(){
        deque.printList();
    }
}
