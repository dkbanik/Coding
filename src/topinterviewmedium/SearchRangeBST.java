package topinterviewmedium;

public class SearchRangeBST {
    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        int target = 6;
        int[] result = searchRange(arr,target);
        System.out.println(result[0]+","+result[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int i = leftSearch(nums,target);
        int j = rightSearch(nums, target);
        return new int[]{i,j};
    }

    public static int leftSearch(int[] arr, int target){
        int index=-1;
        int left = 0; int right = arr.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid] > target){
                right = mid-1;
            }
            else if(arr[mid] == target){
                if(mid != 0 && arr[mid-1] == target) {
                    right = mid;
                }else{
                    return mid;
                }
            }
            else{
                left = mid+1;
            }
        }
        return -1;
    }
    public static int rightSearch(int[] arr, int target){
        int index=-1;
        int left = 0; int right = arr.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid] > target){
                right = mid-1;
            }
            else if(arr[mid] == target){
                if(mid != right && arr[mid+1] == target) {
                    left = mid+1;
                }
                else{
                    return mid;
                }
            }
            else{
                left = mid+1;
            }
        }
        return -1;
    }
}
