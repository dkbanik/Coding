package wrap.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
// https://leetcode.com/problems/longest-string-chain/
// https://www.youtube.com/watch?v=pXG3uE_KqZM
public class LongestStringChain {
    public static void main(String[] args) {
        String[] words ={"a","b","ba","bca","bda","bdca"};
        System.out.println(longestStrChain(words));

    }

    public static int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b) -> a.length()-b.length());
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for(String word : words){
            map.put(word,1);
            for(int i=0;i<word.length();i++){
                StringBuilder str = new StringBuilder(word);
                String next = str.deleteCharAt(i).toString();
                if(map.containsKey(next)){
                    map.put(word, Math.max(map.get(word),map.get(next)+1));
                }
            }
            max = Math.max(max,map.get(word));
        }
        return max;
    }
}
