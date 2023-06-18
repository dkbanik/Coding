package dynamicprogramming;

public class DelOpTwoStrings {
    public static void main(String[] args) {
        String word1 = "leetcode";
        String word2 = "etco";
        System.out.println(minDistance(word1,word2));
    }

    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] cache = new int[len2+1][len1+1];

        cache[0][0] = 0;
        for(int i=1;i<=len1;i++){
            cache[0][i] = i;
        }
        for(int i=1;i<=len2;i++){
            cache[i][0] = i;
        }
        for(int i=1;i<=len2;i++){
            for(int j=1;j<=len1;j++){
                if(word2.charAt(i-1) == word1.charAt(j-1)){
                    cache[i][j] = cache[i-1][j-1];
                }
                else{
                    cache[i][j] = 1 + Math.min(cache[i][j-1],cache[i-1][j]);
                }
            }
        }

        return cache[len2][len1];
    }
}
