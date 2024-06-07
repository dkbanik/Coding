package wrap.dynamicprogramming;

import java.util.Arrays;

// https://leetcode.com/problems/delete-operation-for-two-strings/description/
public class DelOpTwoStrings {
    public static void main(String[] args) {
        String word1 = "leetcode";
        String word2 = "etco";
        System.out.println(minDistance(word1,word2));
        System.out.println(deleteOp(word1, word2));
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

    public static int deleteOp(String word1, String word2){

        int len1 = word1.length();
        int len2 = word2.length();

        int deleteDp[][] = new int[len1][len2];
        for(int i=0;i<len1;i++){
            Arrays.fill(deleteDp[i],-1);

        }

        return recursivelyDelete(word1, word2, len1-1, len2-1, deleteDp);

    }

    private static int recursivelyDelete(String word1, String word2, int index1, int index2, int[][] deleteDp) {
        // ran out of chars, then other word all chars need to be deleted
        if(index1 == -1) return index2 + 1;
        if(index2 == -1) return index1 + 1;

        if(deleteDp[index1][index2] != -1) return deleteDp[index1][index2];

        if(word1.charAt(index1) == word2.charAt(index2)) {
            return recursivelyDelete(word1,word2,index1-1, index2-1, deleteDp);
        }

        int choice1 = recursivelyDelete(word1, word2, index1-1, index2, deleteDp);
        int choice2 = recursivelyDelete(word1,word2, index1, index2-1, deleteDp);

        deleteDp[index1][index2] = 1 + Math.min(choice1, choice2);
        return deleteDp[index1][index2];
    }
}
