package wrap.java_concepts;

public class StringImmutable {
    public static void main(String[] args) {
        String s1 = "Hi";
        String s2 = "Hi"; // object hi , ref same for s1 n s2

        s2= "hihi"; // new ref , new object hihi created in string pool

        System.out.println("s1 "+s1);
        System.out.println("s2 "+s2);

        String s3 = "bye";
        s1.concat(s3);
        System.out.println(s1); // ans "hi", hibye object present in pool but no ref

        String s4 = s1.concat(s3);
        System.out.println(s4); // hibye object got ref now

        String s5 = new String("debo");
        System.out.println(s5); // 2 objects created, once in pool n another in heap

        s5.concat("jit");
        System.out.println(s5); // no ref

        String s6 = s5.concat("jit");
        System.out.println(s6);
    }
}
