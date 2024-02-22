package wrap.topinterviewmedium;

import java.util.HashSet;
import java.util.Set;

public class HouseAtm {
    public static void main(String[] args) {
        // house -> 1
        // atm -> 0
        int[][] grid = {{1,1,1},{0,1,1},{1,1,1},{0,1,1}};
        int[][] result = findDistance(grid);
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }

        // i/p
        /*
        * 1 1 1   (0,1)
        * 0 1 1   (1,2) abs( (1-0) + (2-1)) , (1,2) to (3,1) => (1-3)+(2-1) = 3
        * 1 1 1
        * 0 1 1
        * */


        // o/p
        /*
        *  1 0 1
        *  0 1 2
        *  0 0 1
        * */
    }

    public static int[][] findDistance(int[][] grid){

        Set<int[]> set = new HashSet<>();
        int m = grid.length;
        int n = grid[0].length;
        int[][] result = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0){
                    set.add(new int[]{i,j});
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    result[i][j] = findMin(set, i, j);
                }
            }
        }
        return result;
    }

    public static int findMin(Set<int[]> set, int i, int j){
        int min = Integer.MAX_VALUE;
        for(int[] item : set){
            int atmI = item[0]; int atmJ = item[1];
            int distance = Math.abs(i - atmI)+Math.abs(j-atmJ);
            if(distance < min){
                min = distance;
            }
        }
        return min;

    }


    public static boolean pathExists(Node node , int target){
        if(node == null){
            return target == 0;
        }

//        if(node.left == null && node.right == null){
//            if(node.val == target) return true;
//            return false;
//        }

        boolean leftFlag = pathExists(node.left, target-node.val);
        boolean rightFlag = pathExists(node.right, target-node.val);

        if(leftFlag || rightFlag) return true;
        return false;
    }
}

class Node{
    int val;
    Node left;
    Node right;
}
