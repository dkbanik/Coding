package topinterviewmedium;

public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaaa"));
    }

    public static void printMatrix(int[][] mat){
        int size = mat.length;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static String longestPalindrome(String s){
        int len = s.length();
        int posI = 0, posJ = 0;
        int maxLen = 0;
        int[][] posMatrix = new int[len][len];
        for(int i=0;i<len-1;i++){
            posMatrix[i][i] = 1;
            if(s.charAt(i) == s.charAt(i+1)){
                posMatrix[i][i+1] = 2;
                maxLen = 2;
                posI = i;posJ=i+1;
            }
        }

        for(int l = 3;l<=len;l++){
            for(int i=0;i<len-l+1;i++){
                int j = i+l-1;
                if(s.charAt(i) == s.charAt(j) && posMatrix[i+1][j-1] >= 1){
                    posMatrix[i][j] = posMatrix[i+1][j-1]+2;
                    if(maxLen < posMatrix[i+1][j-1]+2){
                        posI = i;
                        posJ = j;
                        maxLen = posMatrix[i+1][j-1]+2;
                    }

                }
            }
        }
        //printMatrix(posMatrix);

        return s.substring(posI,posJ+1);

    }
}
