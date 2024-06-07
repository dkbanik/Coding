package wrap.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stream4 {
    public static void main(String[] args) {
        //use Java Streams to convert a list of strings to a list of their lengths
        List<String> names = Arrays.asList("a", "ab", "abc");
        List<Integer> lengths = names.stream()
                .map(s -> s.length())
                .collect(Collectors.toList());
        System.out.println(lengths);

        // group a list of strings by their lengths
        List<String> strings = Arrays.asList("one", "two", "three", "four", "five");

        Map<Integer, List<String>> groupedStrings = strings.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(groupedStrings);
    }
}
