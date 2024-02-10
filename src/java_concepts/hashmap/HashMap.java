package java_concepts.hashmap;

public class HashMap<K, V>{

    private final int initialSize = 1 << 4;
    private final int MAXIMUM_CAPACITY = 1 << 30;
    EntrySet[] hashtable;

    HashMap(){
        this.hashtable = new EntrySet[initialSize];
    }

    HashMap(int capacity){
        int size = tableSize(capacity);
        this.hashtable = new EntrySet[size];
    }

    private int tableSize(int capacity) {
            // Subtract 1 from the given capacity
            int n = capacity - 1;

            // Bitwise OR operation with right shift by 1
            n |= n >>> 1;

            // Bitwise OR operation with right shift by 2
            n |= n >>> 2;

            // Bitwise OR operation with right shift by 4
            n |= n >>> 4;

            // Bitwise OR operation with right shift by 8
            n |= n >>> 8;

            // Bitwise OR operation with right shift by 16
            n |= n >>> 16;

            // Ensure the result is greater than or equal to 0
            // If it is negative, return 1; if it exceeds MAXIMUM_CAPACITY, return MAXIMUM_CAPACITY; otherwise, return n + 1
            return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public void put(K key, V value){
        int hashcode = key.hashCode() % hashtable.length;
        EntrySet entry = hashtable[hashcode];
        if(entry == null){
            entry = new EntrySet(key, value, null);
            hashtable[hashcode] = entry;
        }
        else {
            EntrySet prev = entry;
            while (entry != null){
                if(entry.key == key){
                    entry.value = value;
                    return;
                }
                prev = entry;
                entry = entry.next;
            }
            entry = new EntrySet<>(key,value,null);
            prev.next = entry;
        }
    }

    public V get(K key){
        int hashcode = key.hashCode() % hashtable.length;
        EntrySet entry = hashtable[hashcode];
        if(entry != null){
            while (entry != null){
                if(entry.key == key){
                    return (V) entry.value;
                }
                entry = entry.next;
            }
        }
        return null;
    }

    class EntrySet<K, V>{
        K key;
        V value;
        EntrySet next;

        public EntrySet(K key, V value, EntrySet next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
