package Tree;

import datastructures.Node;
import datastructures.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderIterative {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = tree.randomTree();
        List<Integer> ans = inorderTraversal(root);
    }
    public static List<Integer> inorderTraversal(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while(!stack.isEmpty() || curr != null){

            if(curr!=null){
                stack.push(curr);
                curr = curr.getLeft();
            }
            else{
                curr = stack.pop();
                list.add(curr.getData());
                curr = curr.getRight();
            }
        }
        return list;
    }
}
