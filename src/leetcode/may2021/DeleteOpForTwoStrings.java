package leetcode.may2021;

public class DeleteOpForTwoStrings {
    public static void main(String[] args) {
        String s1 = "sea";
        String s2 = "eat";
        System.out.println(minDistance(s1,s2));
    }

    private static int minDistance(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];
        dp[0][0] = 0;
        for(int i=1;i<=n2;i++){
            dp[0][i]=i;
        }
        for(int i=1;i<=n1;i++){
            dp[i][0]=i;
        }
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j];
                }
                else{
                    dp[i+1][j+1] = 1 + Math.min(dp[i][j+1],dp[i+1][j]);
                }
            }
        }

        return dp[n1][n2];
    }
}
