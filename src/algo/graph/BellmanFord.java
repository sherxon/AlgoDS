package algo.graph;

import ds.graph.Edge;
import ds.graph.Vertex;
import ds.graph.WeightedGraph;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by sherxon on 1/7/17.
 */
public class BellmanFord<V, E extends Number>  {
    WeightedGraph<V, E> graph;

    public BellmanFord(WeightedGraph<V, E> graph) {
        this.graph = graph;
    }

   public void shortestPath(V v){
       // initialize
       Vertex<V> source=graph.getVertex(v);
       for (Vertex<V> vertex : graph.getVertices()) {
           if(source==vertex)vertex.setWeight(0);
           else vertex.setWeight(Integer.MAX_VALUE);
       }
       // shortest path
       List<Edge> edges=new LinkedList<>();
       for (Vertex<V> vertex : graph.getVertices())
           edges.addAll(graph.getEdges(vertex.getValue()));

       for (int i = 0; i < graph.size()-1; i++) {
           for (Edge edge : edges) {
               Integer newPath=edge.getFrom().getWeight() +edge.getWeight().intValue();
               if(edge.getTo().getWeight() > newPath){
                   edge.getTo().setWeight(newPath);
                   edge.getTo().setParent(edge.getFrom());
               }
           }
       }
       //check negative cycle



   }


    public void printPath(V h) {
        Vertex<V> root=graph.getVertex(h);
        if(root==null)return;
        while (root.getParent()!=null){
            System.out.print(root.getValue() + " " + root.getWeight() + " ");
            root=root.getParent();
        }
        System.out.println("a 0");
    }
}
