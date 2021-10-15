package topinterviewmedium;

import datastructures.Tree;

import java.util.*;

public class TreeZigzagLevelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Map<Integer, List<Integer>> map = new HashMap<>();
        zigzag(map,1,root);
        List<List<Integer>> result = new ArrayList<>();
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            int level = entry.getKey();
            List<Integer> list = entry.getValue();
            if(level%2 == 0){
                Collections.reverse(list);
            }
            result.add(list);
        }

        for(List<Integer> innerList : result){
            for(int val: innerList){
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void zigzag(Map<Integer, List<Integer>> map, int level, TreeNode root){
        if(root == null)return ;
        List<Integer> list = null;
        if(!map.containsKey(level)){
            list = new ArrayList<>();
            list.add(root.val);
            map.put(level, list);
        }else{
            list = map.get(level);
            list.add(root.val);
        }
        zigzag(map,level+1,root.left);
        zigzag(map,level+1,root.right);
        return ;
    }
}
