package wrap.datastructures;
import java.util.LinkedList;
public class Graph {
    private int V;
    private LinkedList<Integer>[] edges;

    public int getV() {
        return V;
    }

    public LinkedList<Integer>[] getEdges() {
        return edges;
    }

    Graph(int v){
        this.V = v;
        this.edges = new LinkedList[v];
        for(int i=0;i<v;i++){
            edges[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int from, int to){
        edges[from].add(to);
    }
}

