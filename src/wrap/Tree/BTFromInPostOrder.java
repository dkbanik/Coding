package wrap.Tree;

import java.util.HashMap;
import java.util.Map;

public class BTFromInPostOrder {
    static int postIndex = 0;
    public static void main(String[] args) {
        int[] inOrder = {9,3,15,20,7};
        int[] postOrder = {9,15,7,20,3};
        Node root = buildTree(inOrder, postOrder);
        printTree(root);
    }

    public static Node buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inOrderMap.put(inorder[i],i);
        }
        postIndex = inorder.length-1;
        return buildTree(inorder,postorder,0,postIndex,inOrderMap);
    }

    public static Node buildTree(int[] inOrder, int[] postOrder, int start, int end, Map inOrderMap){
        if(start>end)return null;

        int pivotValue = findPivot(inOrderMap,postOrder, start, end, postIndex);
        if(pivotValue == -1)return null;
        Node curr = new Node(pivotValue);

        if(start == end)return curr;

        int inIndex = (int) inOrderMap.get(curr.val);

        curr.left = buildTree(inOrder,postOrder,start,inIndex-1,inOrderMap);
        curr.right = buildTree(inOrder,postOrder,inIndex+1,end,inOrderMap);
        return curr;
    }

    private static int findPivot(Map inOrderMap, int[] postOrder, int start, int end, int j) {

        // iterate over postover, check the value in inOrderMap is between start and end,
        // when found return
        int tempIndex;
        while(j>=0){
            tempIndex = (int) inOrderMap.get(postOrder[j]);
            if(tempIndex>=start && tempIndex<=end){
                return postOrder[j];
            }
            j--;
        }
        return -1;
    }

    public static void printTree(Node root){
        if(root == null) return;
        printTree(root.left);
        System.out.println(root.val+",");
        printTree(root.right);
    }
}
