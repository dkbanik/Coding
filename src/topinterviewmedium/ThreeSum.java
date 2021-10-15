package topinterviewmedium;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
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
