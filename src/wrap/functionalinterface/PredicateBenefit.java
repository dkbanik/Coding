package wrap.functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateBenefit {
    public static void main(String[] args) {
        // we have list of strings and we want to filter out null, empty, whitespace
        // will do without Predicate & with predicate to understand the usage
        List<String> stringList = Arrays.asList("abc", "   ","",null," deb ");
        System.out.println("Without predicate "+withoutPredicate(stringList));
        System.out.println("With predicate "+withPredicate(stringList));
    }
    public static List<String> withoutPredicate(List<String> stringList){
        List<String> nonEmptyStrings = stringList.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toList());

        return nonEmptyStrings;
    }

    // we are concisely wrapping the isEmpty in a Predicate through lamdas
    public static List<String> withPredicate(List<String> stringList){
        Predicate<String> isEmpty = s -> s != null && !s.trim().isEmpty();
        List<String> nonEmptyStrings = stringList.stream()
                .filter(isEmpty)
                .collect(Collectors.toList());

        return nonEmptyStrings;
    }
}
