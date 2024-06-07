package wrap.functionalinterface;

import java.util.function.Predicate;

public class PredicateUse {
    public static void main(String[] args) {
        Predicate<String> isNull = s -> s == null;
        Predicate<String> isBlank = s -> s.trim().isEmpty();
        // here we use .or() predicate to chain the methods
        Predicate<String> isEmpty = isNull.or(isBlank);
        String str1 = "deb";
        String str2 = "   ";
        String str3 = null;
        System.out.println("Str1 is empty? " + isEmpty.test(str1));
        System.out.println("Str2 is empty? " + isEmpty.test(str2));
        System.out.println("Str3 is empty? " + isEmpty.test(str3));

    }
}
