package Tree;


public class BinaryTreeCamera {
    static int cam =0;
    public static void main(String[] args) {
        // 2 -> has cam
        // 1 -> covered with cam
        // 0 -> not covered with cam

        Node node = new Node(0);
        node.left = new Node(0);
        System.out.println(minCameraCover(node));


    }
    public static int minCameraCover(Node root) {

        int ans = minCamNeeded(root);

        return ans == 0 ? cam+1 : cam;
    }

    public static int minCamNeeded(Node root){
        if(root == null)return 1;

        int left = minCamNeeded(root.left);
        int right = minCamNeeded(root.right);

        if(left == 0 || right == 0){
            cam++;
            return 2;
        }
        else if(left == 2 || right == 2){
            return 1;
        }
        else{
            return 0;
        }
    }
}
