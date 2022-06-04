package topinterviewmedium;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,6,7,8,9};
        int key = 10;

        System.out.println(binarySearch(arr,key));
    }

    public static int binarySearch(int[] arr, int key){
        int l = 0;
        int h = arr.length-1;
        while(l<=h){
            int mid = (l+h)/2;
            if(arr[mid] == key) return mid;
            else if(arr[mid] > key){
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return -1;
    }
}
