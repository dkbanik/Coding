package topinterviewmedium;

public class SearchRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4,5,6,1,2,3};
        int key = 3;
        int index = pivotedBinarySearch(arr, arr.length, key);
        System.out.println(index);
    }
    public static int pivotedBinarySearch(int[] arr, int n, int key){
        int pivot = findPivot(arr, 0, n-1, key);

        if(pivot == -1) return binarySearch(arr,0,n-1,key);
        if(arr[pivot] == key) return pivot;

        if(arr[0] <= key) return binarySearch(arr,0,pivot-1,key);
        return binarySearch(arr,pivot+1,n-1,key);
    }

    public static int findPivot(int[] arr, int l, int h, int key){
        if(h<l)return -1;
        if(h==l)return l;

        int mid = (l+h)/2;

        if(mid < h && arr[mid] > arr[mid+1])return mid;
        if(mid > l && arr[mid] < arr[mid-1]) return mid-1;
        if(arr[l] >= arr[mid]) return findPivot(arr,l,mid-1, key);
        return findPivot(arr,mid+1,h,key);
    }

    public static int binarySearch(int[] arr, int l, int h, int key){
        if(h<l)return -1;
        int mid = (l+h)/2;

        if(arr[mid] == key)return mid;
        if(key > arr[mid])return binarySearch(arr, mid+1, h,key);
        return binarySearch(arr,l,mid-1,key);
    }
}
