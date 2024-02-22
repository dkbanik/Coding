package wrap.Tree;

import wrap.datastructures.Node;
import wrap.datastructures.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeDeserialize {

    static int index=0;

    public static void main(String[] args) {
        Tree tree = new Tree();
        //Node root = new Node(1);
        Node root = tree.randomTree();
        print(root);
        System.out.println();
        String serializedString = serialize(root);
        Node root1 = deserialize(serializedString);
        print(root1);

    }

    public static String serialize(Node root){
        List<String> list = new ArrayList<>();

        traverseTree(root,list);
        return String.join(",",list);
    }

    public static Node deserialize(String str){
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(str.split(",")));

        return deserialize(queue);
    }

    public static Node deserialize(Queue<String> queue){
        String value = queue.poll();

        if(value.equals("#")){
            return null;
        }

        Node root = new Node(Integer.parseInt(value));

        root.setLeft(deserialize(queue));
        root.setRight(deserialize(queue));
        return root;
    }

    public static Node deserialize(String[] str){
        if(index>str.length || str[index].equals("#")){
            return null;
        }
        Node root = new Node(Integer.parseInt(str[index]));
        index++;
        root.setLeft(deserialize(str));
        index++;
        root.setRight(deserialize(str));

        return root;
    }

    private static void traverseTree(Node root, List<String> list){
        if(root == null){
            list.add("#");
            return;
        }
        else{
            list.add(""+root.getData());
        }
        traverseTree(root.getLeft(),list);
        traverseTree(root.getRight(),list);

    }

    public static void print(Node root){
        if(root == null)return;

        print(root.getLeft());
        System.out.print(""+root.getData()+",");
        print(root.getRight());
    }
}
