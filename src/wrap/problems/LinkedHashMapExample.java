package wrap.problems;

import java.util.LinkedHashMap;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        LinkedHashMap<Integer,String> map = new LinkedHashMap<>(16, .75f, true);
        System.out.println("Before changes");
        map.put(1,"Ram");
        map.put(2,"Sham");
        map.put(3,"Jadhu");
        map.put(4,"Madhu");

        for(String value: map.values()){
            System.out.println(value);
        }
        System.out.println("After changes");
        String val = map.get(3);
        map.put(2,"Sita");

        for(String value: map.values()){
            System.out.println(value);
        }
    }
}
