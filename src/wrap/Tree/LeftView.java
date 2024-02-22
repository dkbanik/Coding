package wrap.Tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class LeftView {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);
        leftView(root);

    }

    public static void leftView(Node root){
        if(root == null) return;
        Map<Integer, Node> map = new TreeMap<>();
        Queue<VerticaLNode> queue = new LinkedList<>();
        queue.add(new VerticaLNode(root,0));
        while (!queue.isEmpty()){
            VerticaLNode temp = queue.poll();
            if(!map.containsKey(temp.horizontalDist)){
                map.put(temp.horizontalDist, temp.node);
            }
            if(temp.node.left != null){
                queue.add(new VerticaLNode(temp.node.left, temp.horizontalDist+1));
            }
            if(temp.node.right != null){
                queue.add(new VerticaLNode(temp.node.right, temp.horizontalDist+1));
            }
        }

        for(Map.Entry<Integer, Node> entry: map.entrySet()){
            System.out.print(entry.getValue().val+" ");
        }
    }
}
