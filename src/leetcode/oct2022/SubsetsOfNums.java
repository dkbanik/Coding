package leetcode.oct2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SubsetsOfNums {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<Stack<Integer>> result = new ArrayList<>();
        Stack<Integer> subset = new Stack<>();
        dfsV2(0,nums,new ArrayList<>());
        //dfs(0, nums, result, subset);
        //System.out.println(result);
    }

    public static void dfs(int index, int[] nums, List<Stack<Integer>> result, Stack<Integer> subset){
        if(index >= nums.length){ //index=0, 1, 2
            Stack newStack = new Stack();
            newStack.addAll(subset);
            result.add(newStack);
            return;
        }
        subset.push(nums[index]); // 1,2,3
        dfs(index+1,nums, result, subset); //

        subset.pop(); // 1,
        dfs(index+1, nums, result, subset); // 3

    }

    public static void dfsV2(int index, int[] nums, List<Integer> path){

        if(index == nums.length){
            System.out.println(path);
        }
        else{
            dfsV2(index+1, nums, path);
            path.add(nums[index]);

            dfsV2(index+1, nums, path);
            path.remove(path.size()-1);
        }

    }

}
