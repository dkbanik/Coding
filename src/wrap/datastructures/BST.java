package wrap.datastructures;

public class BST {
    public static void main(String[] args) {
        int[] arr = {2,3,1,5,7,4};
//        Node root = null;
//        for(int i=0;i<arr.length;i++){
//            root = constructBST(root,arr[i]);
//        }
//        inOrder(root);

        int[] arr1 = {1,2,4,5,6,7,8,9};
        System.out.println(binarySearch(arr1,5));
    }

    public static int binarySearch(int[] arr, int num){
        int left = 0; int right = arr.length-1;
        while(left<=right){ 
            int mid = (left+right)/2;
            if(num == arr[mid]){
                return mid;
            }
            if(num > arr[mid]){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        return -1;
    }

    public static Node constructBST(Node root, int val){
        if(root == null){
            return new Node(val);
        }
        if(val > root.data){
            root.right = constructBST(root.right,val);
        }
        else{
            root.left = constructBST(root.left,val);
        }
        return root;
    }

    public static void inOrder(Node root){
        if(root == null)return;
        inOrder(root.left);
        System.out.print(root.data + ",");
        inOrder(root.right);
    }
}
