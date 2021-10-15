package topinterviewmedium;

import java.util.*;

public class TopKFrequentNums {
    public static void main(String[] args) {
        int k = 2;
        int[] nums = {2,2,1,1,3,2,1};
        int[] result = topKFrequent(nums,k);
        for(int val: result){
            System.out.print(val+" ");
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer,Integer> countMap = new HashMap<>();
        for(int val: nums){
            countMap.put(val, countMap.getOrDefault(val,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(
                (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : b.getValue()-a.getValue()
        );

        for(Map.Entry<Integer,Integer> entry : countMap.entrySet()){
            pq.offer(entry);
        }

//        while(!pq.isEmpty()){
//            System.out.println("pq: "+pq.poll());
//        }

        while(k>0){
            result[--k] = pq.poll().getKey();
        }
        return result;
    }
}
