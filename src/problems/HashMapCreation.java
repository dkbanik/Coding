package problems;

import java.util.Arrays;

class ListNode{
    String key;
    int value;
    ListNode next;

    public ListNode(String key, int value, ListNode next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}

class HashMapper{
    static final int size = 10001;
    ListNode[] list = new ListNode[size];

    public int hash(String key) {
        return Math.abs(Arrays.hashCode(key.toCharArray())%size);
    }

    public int get(String key){
        int hashKey = hash(key);
        ListNode node = list[hashKey];
        if(node == null) return -1;
        if(node.key == key) return node.value;
        while(node.next!=null){
            if(node.next.key == key) return node.next.value;
            node = node.next;
        }
        return -1;
    }

    public void remove(String key){
        int hashKey = hash(key);
        ListNode node = list[hashKey];
        if (node == null) return;
        if(node.key == key) list[hashKey] = node.next;
        else{
            while(node.next!=null){
                if(node.next.key == key) {
                    node.next = node.next.next;
                    return;
                }
                node = node.next;
            }
        }

    }
    public void put(String key, int value){
        remove(key);
        int hashKey = hash(key);
        ListNode node = new ListNode(key,value, list[hashKey]);
        list[hashKey] = node;
    }
}
public class HashMapCreation {
    public static void main(String[] args) {
        HashMapper mapper = new HashMapper();
        mapper.put("a", 3);
        mapper.put("b", 5);
        mapper.put("c", 4);
        System.out.println(mapper.get("b"));
        mapper.put("b",6);
        System.out.println(mapper.get("b"));
        mapper.remove("b");
        System.out.println(mapper.get("b"));
    }
}
