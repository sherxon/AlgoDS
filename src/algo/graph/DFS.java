package algo.graph;

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
        Stack<Vertex<T>> stack= new Stack<>();
        stack.add(vertex);
        while (!stack.isEmpty()){
            Vertex<T> v=stack.pop();
            v.setVisited(true);
            for (Vertex<T> tVertex : v.getNeighbors()) {
                if(!tVertex.isVisited()){
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
