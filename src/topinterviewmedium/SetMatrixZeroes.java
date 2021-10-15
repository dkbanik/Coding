package topinterviewmedium;

import java.util.Arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void setZeroes(int[][] matrix){
        boolean colHasZeroFlag = false;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int i=0;i<rows;i++){
            if(matrix[i][0] == 0) colHasZeroFlag = true;
            for(int j=1;j<cols;j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i=rows-1;i>=0;i--){
            for(int j=cols-1;j>0;j--){
                if(matrix[0][j] == 0 || matrix[i][0]==0){
                    matrix[i][j] = 0;
                }
            }
            if(colHasZeroFlag) matrix[i][0]=0;
        }

        return;
    }
}
