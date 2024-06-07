package wrap.functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionBenefit {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        System.out.println(withoutFunction(strings));
        System.out.println(withFunction(strings));
    }
    public static int getLength(String s) {
        return s.length();
    }
    public static List<Integer> withoutFunction(List<String> strings){
        List<Integer> list = strings.stream()
                                    .map(s -> getLength(s))
                                    .collect(Collectors.toList());
        return list;
    }

    // here we didnt need to create another method in this class coz of use of Function
    // if we know the Function wont be used anywhere else in the class we can code this way
    // this helps readibility of the code
    public static List<Integer> withFunction(List<String> strings){
        Function<String, Integer> length = s -> s.length();
        List<Integer> list = strings.stream()
                                    .map(length)
                                    .collect(Collectors.toList());
        return list;
    }
}
