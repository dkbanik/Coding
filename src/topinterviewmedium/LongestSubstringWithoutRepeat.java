package topinterviewmedium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://www.youtube.com/watch?v=qtVh-XEpsJo
public class LongestSubstringWithoutRepeat {
    public static void main(String[] args) {
        String s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int len = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (charMap.containsKey(ch)) {
                left = Math.max(charMap.get(ch) + 1, left);
            }
            len = Math.max(len, right - left + 1);
            charMap.put(ch, right);
            right++;
        }
        return len;
    }
}
