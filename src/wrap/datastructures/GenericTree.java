package wrap.datastructures;

public class GenericTree {
    GenericNode root;

    public GenericTree(GenericNode root) {
        this.root = root;
    }

    public GenericNode getRoot() {
        return root;
    }

    public void setRoot(GenericNode root) {
        this.root = root;
    }


    public GenericNode buildBinaryTreeOfHeight(GenericNode root, int size){
        if(size == 0 )return root;
        int rootValue = root.getData();
        System.out.println(rootValue);
        GenericNode leftChild = new GenericNode(rootValue*2);
        GenericNode rightChild = new GenericNode(rootValue*2+1);
        root.addChild(buildBinaryTreeOfHeight(leftChild,size-1));
        root.addChild(buildBinaryTreeOfHeight(rightChild,size-1));
        return root;
    }

    public void printBinaryTree(GenericNode root){
        if(root == null)return;
        System.out.print(root.getData()+" ");
        if(!root.getChildren().isEmpty()){
            printBinaryTree(root.getChildren().get(0));
            printBinaryTree(root.getChildren().get(1));
        }
    }

    public void printTree(GenericNode root){
        if(root == null)return;
        System.out.print(root.getData()+" ");
        if(!root.getChildren().isEmpty()){
            for(int i=0;i<root.getChildren().size();i++){
                printTree(root.getChildren().get(i));
            }
        }
    }
}
