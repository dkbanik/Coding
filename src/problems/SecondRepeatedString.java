package problems;

import java.util.HashMap;
import java.util.Map;

public class SecondRepeatedString {
    public static String findSecondMostRepeatedString(String[] input){
        String ans = "";
        Map<String,Integer> textCountMapper = new HashMap<>();
        for (String str: input){
            textCountMapper.put(str, textCountMapper.getOrDefault(str,0)+1);
        }
        int max = Integer.MIN_VALUE;
        int secondMax = max;
        for(Map.Entry<String, Integer> entry: textCountMapper.entrySet()){
            if(entry.getValue() > max){
                secondMax=max;
                max= entry.getValue();
            }
            else if (entry.getValue() > secondMax && entry.getValue() != max){
                secondMax = entry.getValue();
            }
        }
        //textCountMapper.entrySet().forEach(i -> {System.out.println(i.getKey()+"->"+i.getValue());});
        System.out.println(secondMax);
        for(Map.Entry<String, Integer> entry: textCountMapper.entrySet()) {
            if (entry.getValue().equals(secondMax)) ans= entry.getKey();
            break;
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] input = {"ram", "ram", "ajay","sham","ajay","ajay","sham"};
        String answer = findSecondMostRepeatedString(input);
        System.out.println("ans:"+answer);
    }
}
