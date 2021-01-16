package datastructures;

public class GenericNodeWithCost extends GenericNode{
    private int cost;

    public GenericNodeWithCost(int data, int cost) {
        super(data);
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
