package wrap.topinterviewmedium.slidingwindow;
/*
* Given a binary array and an integer k, find the position of zeroes flipping which creates maximum number of consecutive 1s in array.
Input: arr = [1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1], m = 2
Output: [5, 7]
Explanation:
We are allowed to flip maximum 2 zeroes. If we flip arr[5] and arr[7], we get 8 consecutive 1's which is
maximum possible under given constraints
* https://www.youtube.com/watch?v=QPfalDbqa4A
 * */
public class MaxConsecutiveOne {
    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
        int k = 2;
        int j=-1;
        int count=0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0){
                count++;
            }
            while (count > k){
                j++;
                if(arr[j] == 0){
                    count--;
                }
            }
            max = Math.max(max, i-j);
        }
        System.out.println(max);
    }
}
