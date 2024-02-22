package wrap.Tree;

import wrap.datastructures.Node;
import wrap.datastructures.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderIterative {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = tree.randomTree();
        List<Integer> ans = postorderTraversal(root);
    }
    public static List<Integer> postorderTraversal(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                stack.push(root);
                root = root.getLeft();
            }


            root = stack.pop();
            if(!stack.isEmpty() && stack.peek() == root) root = root.getRight();
            else{
                list.add(root.getData());
                root = null;
            }
        }
        return list;
    }
}
