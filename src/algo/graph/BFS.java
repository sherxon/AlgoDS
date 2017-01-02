package algo.graph;

import ds.graph.Graph;
import ds.graph.UndirectedGraph;
import ds.graph.Vertex;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sherxon on 1/1/17.
 */
public class BFS<T> {
    public static void main(String[] args) {
        //Graph<String> graph= new DirectedGraph<>();
        Graph<String> graph= new UndirectedGraph<>();
        graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");
        graph.addVertex("d");
        graph.addVertex("e");
        graph.addVertex("f");
        graph.addVertex("g");
        graph.addEdge("a", "b");
        graph.addEdge("a", "d");
        graph.addEdge("a", "c");
        graph.addEdge("b", "f");
        graph.addEdge("c", "e");
        graph.addEdge("e", "g");
        BFS<String> bfs= new BFS<>(graph);
        bfs.search("a");
        bfs.printPathFrom("g");
    }


    Graph<T> graph;

    public BFS(Graph<T> graph) {
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
