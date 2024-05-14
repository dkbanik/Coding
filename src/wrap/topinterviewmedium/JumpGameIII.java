package wrap.topinterviewmedium;
/*
https://leetcode.com/problems/jump-game-iii/
Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach any index with value 0.
Notice that you can not jump outside of the array at any time.
*/
public class JumpGameIII {
    public static void main(String[] args) {
        int[] arr ={4,2,3,0,3,1,2};
        int[] arr1 = {3,0,2,1,2};
        int start = 2;
        System.out.println(canReach(arr1,start));
    }

    public static boolean canReach(int[] arr, int start) {
        int length = arr.length;
        boolean[] visited = new boolean[length];
        return checkReach(visited, start, arr);
    }

    private static boolean checkReach(boolean[] visited, int index, int[] arr) {
        if(index < 0 || index > arr.length-1) return false;
        if(visited[index]) return false;

        visited[index] = true;
        if(arr[index] == 0) return true;

        int leftJumpIndex = index-arr[index];
        int rightJumpIndex = index+arr[index];
        boolean canLeftReached = checkReach(visited, leftJumpIndex, arr);
        boolean canRightReached = checkReach(visited, rightJumpIndex, arr);
        return canLeftReached || canRightReached;
    }
}
