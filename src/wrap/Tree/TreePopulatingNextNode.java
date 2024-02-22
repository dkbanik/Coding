package wrap.Tree;
class ModifiedTreeNode {
    int val;
    ModifiedTreeNode left;
    ModifiedTreeNode right;
    ModifiedTreeNode next;

    ModifiedTreeNode() {
    }

    ModifiedTreeNode(int val) {
        this.val = val;
    }

    ModifiedTreeNode(int val, ModifiedTreeNode left, ModifiedTreeNode right, ModifiedTreeNode next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
public class TreePopulatingNextNode {
    public static void main(String[] args) {
        ModifiedTreeNode root = new ModifiedTreeNode(1);
        root.left = new ModifiedTreeNode(2);
        root.right = new ModifiedTreeNode(3);

        root.left.left = new ModifiedTreeNode(4);
        root.left.right = new ModifiedTreeNode(5);

        root.right.left = new ModifiedTreeNode(6);
        root.right.right = new ModifiedTreeNode(7);
        ModifiedTreeNode res = connect(root);
        inOrderTraversal(res);

    }
    public static ModifiedTreeNode connect(ModifiedTreeNode root) {
        if(root == null) return null;

        ModifiedTreeNode head = root;

        while(head != null){
            ModifiedTreeNode dummy = new ModifiedTreeNode(0);
            ModifiedTreeNode temp = dummy;
            while(head != null){
                if(head.left != null){
                    temp.next = head.left;
                    temp = temp.next;
                }
                if(head.right != null){
                    temp.next = head.right;
                    temp = temp.next;
                }
                head = head.next;
            }
            head = dummy.next;
        }
        return root;
    }

    public static void inOrderTraversal(ModifiedTreeNode root){
        if(root == null)return;
        inOrderTraversal(root.left);
        System.out.print(root.val+",");
        inOrderTraversal(root.right);
    }
}
