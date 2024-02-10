package java_concepts.hashmap;

public class main {
    public static void main(String[] args) {
        HashMap map = new HashMap<String, String>(77);
        map.put("a", "asdad");
        map.put("b", "skdjfskdf");
        System.out.println(map.get("a"));
        map.put("a", "bkckdjv");
        System.out.println(map.get("a"));
        System.out.println(map.get("b"));
    }
}
