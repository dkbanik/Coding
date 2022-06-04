package Tree;

import java.util.*;

public class LevelOrder {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.left = new Node(7);
        root.left.right.right.right = new Node(6);
        levelOrder(root);

    }
    public static void levelOrder(Node root){
        Queue<VerticaLNode> queue = new LinkedList<>();
        if(root == null)return;
        Map<Integer, List<Node>> map = new HashMap<>();

        queue.add(new VerticaLNode(root,0));
        while (!queue.isEmpty()){
            VerticaLNode temp = queue.poll();
            List<Node> list = map.get(temp.horizontalDist);
            if(list == null){
                list = new ArrayList<>();
            }
            list.add(temp.node);
            map.put(temp.horizontalDist, list);

            if(temp.node.left != null){
                queue.add(new VerticaLNode(temp.node.left, temp.horizontalDist+1));
            }

            if(temp.node.right != null){
                queue.add(new VerticaLNode(temp.node.right, temp.horizontalDist+1 ));
            }
        }

        for(Map.Entry<Integer, List<Node>> entry: map.entrySet()){
            entry.getValue().forEach(item -> System.out.print(item.val+" "));
            System.out.println();
        }
    }
}
