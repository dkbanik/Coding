package wrap.Tree;

import wrap.datastructures.Node;
import wrap.datastructures.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderIterative {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = tree.randomTree();
        List<Integer> ans = preorderTraversal(root);
    }

    public static List<Integer> preorderTraversal(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                list.add(root.getData());
                if(root.getRight() != null)stack.push(root.getRight());
                root=root.getLeft();
            }
            if(!stack.isEmpty())root = stack.pop();
        }
        return list;
    }
}
