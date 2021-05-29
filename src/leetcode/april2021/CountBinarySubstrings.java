package leetcode.april2021;

//https://leetcode.com/explore/featured/card/april-leetcoding-challenge-2021/596/week-4-april-22nd-april-28th/3718/
public class CountBinarySubstrings {
    public static void main(String[] args) {

        String str= "10101";
        int ans = countBinarySubstring(str);
        System.out.println(ans);
    }

    private static int countBinarySubstring(String s) {
        int ans = 0, prev = 0, cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) != s.charAt(i)) {
                ans += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            } else {
                cur++;
            }
        }
        return ans + Math.min(prev, cur);
    }
}
