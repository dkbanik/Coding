package datastructures;

import java.util.ArrayList;
import java.util.List;

public class GenericNode {
    private int data;
    private GenericNode parent;
    private List<GenericNode> children;

    public GenericNode(int data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public GenericNode getParent() {
        return parent;
    }

    public void setParent(GenericNode parent) {
        this.parent = parent;
    }

    public List<GenericNode> getChildren() {
        return this.children;
    }

    public void addChild(GenericNode child){
        this.children.add(child);
        child.setParent(this);
    }

    public void setChildren(List<GenericNode> children) {
        for(GenericNode child : children){
            child.setParent(this);
        }
        this.children = children;
    }
}
