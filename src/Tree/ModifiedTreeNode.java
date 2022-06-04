package Tree;

public class ModifiedTreeNode {
    Node node;
    int horizontalDistance;
    int level;

    public ModifiedTreeNode(Node node, int horizontalDistance, int level) {
        this.node = node;
        this.horizontalDistance = horizontalDistance;
        this.level = level;
    }
}
