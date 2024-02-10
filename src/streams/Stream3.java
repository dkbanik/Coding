package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream3 {
    public static void main(String[] args) {
        findDistinctChar();
        flattenListOfList();
    }
    //Finding Distinct Characters from a List of Words
    public static void findDistinctChar(){
        List<String> words = Arrays.asList("hello", "world");

        List<Character> result = words.stream()
                .flatMap(word -> word.chars().mapToObj(ch -> (char) ch))
                                      .distinct()
                                      .collect(Collectors.toList());
        System.out.println(result);
    }

    public static void flattenListOfList(){
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9));

        List<Integer> result = listOfLists.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
