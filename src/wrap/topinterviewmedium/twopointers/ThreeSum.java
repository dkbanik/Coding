package wrap.topinterviewmedium.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/*
* https://leetcode.com/problems/3sum/description/
* https://www.youtube.com/watch?v=DhFh8Kw7ymk
*
* Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
* Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
* */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
        System.out.println(threeSum2(nums));
    }

    public static List<List<Integer>> threeSum2(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n= nums.length;
        for(int i=0;i<n;i++){
            if(i>0 && nums[i] == nums[i-1])continue;
            int j=i+1;
            int k=n-1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0)
                    j++;
                else if(sum > 0)
                    k--;
                else {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j] , nums[k]);
                    result.add(triplet);
                    j++;k--;
                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--;
                }
            }

        }
        return result;


    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        if(nums == null || nums.length < 3) return output;

        Arrays.sort(nums);

        Set<String> duplicateTriplets = new HashSet<>();
        int twoPairSum;
        for (int i = 0; i < nums.length; i++) {
            List<Integer> tripletList = null;
            int firstTriplet = nums[i];
            twoPairSum = 0 - nums[i];
            Map<Integer, Integer> twoPairMap = new HashMap<>();
            for (int j = i+1; j < nums.length; j++) {

                int secondTriplet = nums[j];
                int thirdTriplet = twoPairSum - secondTriplet;
                if (twoPairMap.containsKey(thirdTriplet)) {
                    String triplet = firstTriplet+","+secondTriplet+","+thirdTriplet;
                    if(!duplicateTriplets.contains(triplet)){
                        tripletList = Arrays.asList(firstTriplet, secondTriplet, thirdTriplet);
                        output.add(tripletList);
                    }
                    duplicateTriplets.add(triplet);
                } else {
                    twoPairMap.putIfAbsent(secondTriplet, 1);
                }

            }

        }
        return output;
    }
}
