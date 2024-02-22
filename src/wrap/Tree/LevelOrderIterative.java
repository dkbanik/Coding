package wrap.Tree;

import wrap.datastructures.Node;
import wrap.datastructures.Tree;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderIterative {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = tree.randomTree();
        List<List<Integer>> ans = levelOrder(root);
    }
    public static List<List<Integer>> levelOrder(Node root){
        List<List<Integer>> listOfList = new ArrayList<>();
        int height = height(root);
        for(int i=1;i<=height;i++){
            List<Integer> list = new ArrayList<>();
            levelOrder(root, i, list);
            listOfList.add(list);
        }
        return listOfList;
    }

    public static void levelOrder(Node root, int level, List<Integer> list){
        if(root == null)return;
        if(level == 1){
            list.add(root.getData());
            return;
        }
        else{
            levelOrder(root.getLeft(), level-1,list);
            levelOrder(root.getRight(),level-1,list);
        }
    }

    public static int height(Node root){
        if(root == null) return 0;
        return Math.max(height(root.getLeft()),height(root.getRight()))+1;
    }
}
