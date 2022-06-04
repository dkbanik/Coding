package Tree;


import java.util.*;
// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
public class VerticalOrderTraversal {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(6);

        node.right.left = new Node(5);
        node.right.right = new Node(7);
        List<List<Integer>> list = verticalTraversal(node);
        System.out.println(list.toString());
    }

    public static List<List<Integer>> verticalTraversal(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        int upperBound = 0;
        int lowerBound = 0;
        Map<Integer, List<ModifiedTreeNode>> map = new HashMap<>();

        Queue<ModifiedTreeNode> q = new LinkedList<>();

        q.add(new ModifiedTreeNode(root,0,0));

        while(!q.isEmpty()){
            ModifiedTreeNode temp = q.poll();
            List<ModifiedTreeNode> list = map.get(temp.horizontalDistance);
            if(list == null){
                list = new ArrayList<>();
            }
            list.add(temp);
            Collections.sort(list,
                    (a, b)-> (a.level == b.level) ? a.node.val - b.node.val : a.level - b.level);
            map.put(temp.horizontalDistance, list);
            if(temp.horizontalDistance > upperBound) upperBound = temp.horizontalDistance;
            if(temp.horizontalDistance < lowerBound) lowerBound = temp.horizontalDistance;
            if(temp.node.left != null){
                q.add(new ModifiedTreeNode(temp.node.left, temp.horizontalDistance-1, temp.level+1));
            }

            if(temp.node.right != null){
                q.add(new ModifiedTreeNode(temp.node.right, temp.horizontalDistance+1, temp.level+1));
            }
        }

        for(int i=lowerBound;i<=upperBound;i++){
            List<ModifiedTreeNode> list = map.get(i);
            List<Integer> temp = new ArrayList<>();
            for(ModifiedTreeNode node : list){
                temp.add(node.node.val);
            }
            result.add(temp);
        }
        return result;
    }

}
