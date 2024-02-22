package wrap.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TopView {
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);
        topView(root);
    }

    public static void topView(Node root){
        if(root == null) return;
        int lowerBound = 0;
        int upperBound = 0;
        Queue<VerticaLNode> queue = new LinkedList<>();
        queue.add(new VerticaLNode(root, 0));
        Map<Integer, Node> map = new HashMap<>();
        while (!queue.isEmpty()){
            VerticaLNode temp = queue.poll();
            if(!map.containsKey(temp.horizontalDist)){
                map.put(temp.horizontalDist, temp.node);
                if(temp.horizontalDist > upperBound) upperBound = temp.horizontalDist;
                if(temp.horizontalDist < lowerBound) lowerBound = temp.horizontalDist;
            }
            if(temp.node.left != null){
                queue.add(new VerticaLNode(temp.node.left,temp.horizontalDist-1));
            }
            if(temp.node.right != null){
                queue.add(new VerticaLNode(temp.node.right,temp.horizontalDist+1 ));
            }
        }

        for(int i=lowerBound;i<=upperBound;i++){
            if(map.containsKey(i)){
                System.out.print(map.get(i).val+" ");
            }
        }

//        for(Map.Entry<Integer, Node> entry : map.entrySet()){
//            System.out.print(entry.getValue().val+" ");
//        }

    }
}
