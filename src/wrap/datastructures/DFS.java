package wrap.datastructures;

import java.util.LinkedList;

public class DFS {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 0);
        g.addEdge(1, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 3);
        g.addEdge(5, 3);

        dfs(g,0,6);
    }

    public static void dfs(Graph g, int startVertex, int numVertices){
        boolean[] visited = new boolean[numVertices];
        visit(g, startVertex, visited);
    }

    public static void visit(Graph g, int vertex, boolean[] visited){
        visited[vertex] = true;
        System.out.println(vertex+" ");
        LinkedList<Integer> edges = g.getEdges()[vertex];
        for(int i=0;i<edges.size();i++){
            int v = edges.get(i);
            if(!visited[v]) visit(g,v,visited);
        }
    }
}
