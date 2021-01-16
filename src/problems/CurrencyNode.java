package problems;

import java.util.ArrayList;
import java.util.List;

public class CurrencyNode {
    private String name;
    private CurrencyNode parent;
    private List<CurrencyNode> children;
    private int cost;

    public CurrencyNode(String name, int cost) {
        this.name = name;
        this.cost = cost;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CurrencyNode getParent() {
        return parent;
    }

    public void setParent(CurrencyNode parent) {
        this.parent = parent;
    }

    public List<CurrencyNode> getChildren() {
        return children;
    }

    public void setChildren(List<CurrencyNode> children) {
        for(CurrencyNode child : children){
            child.setParent(this);
        }
        this.children = children;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void addChild(CurrencyNode child){
        this.children.add(child);
        child.setParent(this);
    }
}
