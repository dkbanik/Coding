package wrap.streams;

import java.util.Arrays;
import java.util.List;

public class Stream2 {
    public static void main(String[] args) {
        totalCharacters();
        sumOfInteger();
        findMaxLength();
        calculateAvg();
    }

    // count total characters of all strings in list
    public static void totalCharacters(){
        List<String> list = Arrays.asList("debojit", "is", "the ", "best");

        int sum =  list.stream().mapToInt(str -> str.length()).sum();
        System.out.println(sum);
    }

    // sum of integer list
    public static void sumOfInteger(){
        List<Integer> list = Arrays.asList(1,2,4,5,6,6);

        int sum = list.stream()
                .mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }

    //find max length of strings
    public static void findMaxLength(){
        List<String> list = Arrays.asList("debojit", "is", "thasdafdsadfe", "best");

        int max = list.stream()
                .mapToInt(String::length).max().orElse(0);

        System.out.println(max);
    }

    // caculate avg of double list
    public static void calculateAvg(){
        List<Double> list = Arrays.asList(1.0,4.0, 6.0, 7.0, 10.0);
        Double avg = list.stream()
                .mapToDouble(Double::doubleValue).average().orElse(0.0);

        System.out.println(avg);
    }
}
