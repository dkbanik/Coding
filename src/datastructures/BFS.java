package datastructures;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
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
        bfs(g,0,6);
    }

    public static void bfs(Graph g, int startVertex, int numVertices){
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[numVertices];
        queue.add(startVertex);
        visited[startVertex] = true;
        visit(g, queue, visited);
    }

    public static void visit(Graph g, Queue<Integer> queue, boolean[] visited ){
        while(!queue.isEmpty()){
            int vertex = queue.poll();
            System.out.println(vertex+" ");
            LinkedList<Integer> edges = g.getEdges()[vertex];
            for(int i=0;i<edges.size();i++){
                int v = edges.get(i);
                if(!visited[v]){
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
    }
}
