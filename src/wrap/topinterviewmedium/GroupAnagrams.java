package wrap.topinterviewmedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> output = groupAnagrams(input);
        for(List<String> group : output){
            for(String str : group){
                System.out.print(str+",");
            }
            System.out.println();
        }

        System.out.println(checkAnagram("eat","tea"));
    }
    public static List<List<String>> groupAnagrams(String[] strs){
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }


    public static List<List<String>> groupAnagrams2(String[] input){
        List<List<String>> output = new ArrayList<>();
        Map<Map<Character, Integer>,List<String>> mainMap = new HashMap<>();

        for(String word : input){
            Map<Character, Integer> fmap = new HashMap<>();
            for(int i=0;i<word.length();i++){
                Character ch = word.charAt(i);
                fmap.put(ch, fmap.getOrDefault(ch,1)+1);
            }

            if(!mainMap.containsKey(fmap)){
                ArrayList<String> list = new ArrayList<>();
                list.add(word);
                mainMap.put(fmap,list);
            }else{
                List<String> list = mainMap.get(fmap);
                list.add(word);
            }
        }

        for(List<String> list : mainMap.values()){
            output.add(list);
        }

        return output;

    }

    public static List<List<String>> groupAnagrams1(String[] input){
        List<List<String>> output = new ArrayList<>();
        int noOfWords = input.length;
        for(int i=0;i<noOfWords;i++){
            String fixedWord = input[i];
            if(fixedWord!= "-1"){
                List<String> anagramGroup = new ArrayList<>();
                for(int j=i;j<noOfWords;j++){
                    if(input[j] != "-1" && checkAnagram(input[j],fixedWord)){
                        anagramGroup.add(input[j]);
                        input[j] = "-1";
                    }
                }
                output.add(anagramGroup);
            }
        }
        return output;
    }
    public static boolean checkAnagram(String s1, String s2){
        if(s1.length() != s2.length())return false;
        int noOfChars = 256;
        int[] count = new int[noOfChars];
        for(int i=0; i<s1.length();i++){
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }

        for(int i=0;i<noOfChars;i++){
            if(count[i] != 0)return false;
        }
        return true;
    }
}
