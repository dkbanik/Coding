package wrap.topinterviewmedium;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 3;
        System.out.println(findKthLargest(nums,k));
    }

    public static int findKthLargest(int[] nums, int k) {
        int ans = -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int val: nums){
            pq.offer(val);
        }

//        while(!pq.isEmpty()){
//            System.out.println(pq.poll());
//        }
        while(k<=nums.length){
            ans = pq.poll();
            k++;
        }
        return ans;
    }
}
