package algo.graph;

import ds.graph.Graph;
import ds.graph.Vertex;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sherxon on 1/1/17.
 */

/**
 * This is traditional top-down approach to traverse graph. This is advantageous when the frontier is small
 */
public class BFS<T> {

    Graph<T, Number> graph;

    public BFS(Graph<T, Number> graph) {
        this.graph = graph;
    }

    public void search(T s){
        clearGraph();
        Vertex<T> root=graph.getVertex(s);
        if(root==null)return;
        Queue<Vertex<T>> queue=new LinkedList<>();
        root.setVisited(true);
        queue.add(root);
        while (!queue.isEmpty()){
            Vertex<T> vertex=queue.remove();
            for (Vertex<T> neighbor : vertex.getNeighbors())
                if(!neighbor.isVisited()){
                    neighbor.setParent(vertex);
                    neighbor.setVisited(true);
                    queue.add(neighbor);
                }
        }
    }

    private  void clearGraph() {
        for (Vertex<T> vertex : graph.getVertices()) {
            vertex.setVisited(false);
            vertex.setParent(null);
        }
    }

    public void printPathFrom(T t){
        Vertex<T> root=graph.getVertex(t);
        if(root==null)return;
        while (root.getParent()!=null){
            System.out.print(root.getValue() + " -> ");
            root=root.getParent();
        }
        System.out.println("a");
    }
}
