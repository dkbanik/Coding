package wrap.problems;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheLinkedHM {

    LinkedHashMap<Integer,Integer> map;

    public LRUCacheLinkedHM(int capacity) {
        map = new LinkedHashMap<Integer,Integer>(capacity,0.75f,true){
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}
