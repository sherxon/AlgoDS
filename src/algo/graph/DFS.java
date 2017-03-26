package algo.graph;

import ds.graph.DirectedGraph;
import ds.graph.Graph;
import ds.graph.Vertex;

import java.util.Stack;

/**
 * Created by sherxon on 1/4/17.
 */
public class DFS<T> {
    Graph<T, Number> graph;

    public DFS(Graph<T, Number> graph) {
        this.graph = graph;
    }

    public static void main(String[] args) {
        Graph<String, Number> graph = new DirectedGraph<>();
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
        DFS<String> dfs= new DFS<>(graph);
        dfs.clearGraph();
        //dfs.search("a");
        dfs.searchIterative("a");
        dfs.printPathFrom("g");
    }

    public void search(T source) {
        Vertex<T> vertex= graph.getVertex(source);
        vertex.setVisited(true);
        for (Vertex<T> tVertex : vertex.getNeighbors())
            if(!tVertex.isVisited()){
                tVertex.setParent(vertex);
                search(tVertex.getValue());
            }
    }
    public void searchIterative(T source) {
        Vertex<T> vertex= graph.getVertex(source);
        vertex.setVisited(true);
        Stack<Vertex<T>> stack= new Stack<>();
        stack.add(vertex);
        while (!stack.isEmpty()){
            Vertex<T> v=stack.pop();
            for (Vertex<T> tVertex : v.getNeighbors()) {
                if(!tVertex.isVisited()){
                    tVertex.setVisited(true);
                    tVertex.setParent(v);
                    stack.add(tVertex);
                }
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
