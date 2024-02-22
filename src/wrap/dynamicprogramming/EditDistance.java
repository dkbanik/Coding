package wrap.dynamicprogramming;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
        String s = "horse";
        String t = "ros";

        System.out.println(editDistance(s,t));
    }

    public static int editDistance(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        int[][] cache = new int[slen][tlen];
        for(int i=0;i<slen;i++){
            Arrays.fill(cache[i],-1);
        }
        return editDistance(cache,s,t,slen-1,tlen-1);
    }

    public static int editDistance(int[][] cache, String s, String t, int m, int n){
        if(m == -1) return n+1;
        if(n == -1) return m+1;

        if(cache[m][n] != -1) return cache[m][n];
        if(s.charAt(m) == t.charAt(n)) return editDistance(cache, s, t, m-1, n-1);

        int choice1 = editDistance(cache, s, t, m, n-1);
        int choice2 = editDistance(cache, s, t, m-1, n);
        int choice3 = editDistance(cache, s, t, m-1, n-1);

        cache[m][n] = 1 + Math.min(choice1, Math.min(choice2, choice3));
        return cache[m][n];
    }
}
