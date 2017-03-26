package algo.graph;

import ds.graph.Edge;
import ds.graph.Vertex;
import ds.graph.WeightedGraph;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by sherxon on 1/7/17.
 */
/**
* This Bellman Ford shortest path algorithm. It works with negative edges and and if there negative cycle
 * the algorithm reports. Time complexity is O(V*E) if E is V^2 , we can say that O(V^3).
 * This is slower than Dijkstra shortest path algorithm which works for only non-negative edges in O(VLogV)
 * with fibonacci heap.
* */
public class BellmanFord<V, E extends Number>  {
    WeightedGraph<V, E> graph;

    public BellmanFord(WeightedGraph<V, E> graph) {
        this.graph = graph;
    }

   public void shortestPath(V v){
       /**
       * Step 1:
       * Initialization  step
       * */
       Vertex<V> source=graph.getVertex(v);
       for (Vertex<V> vertex : graph.getVertices()) {
           if(source==vertex)vertex.setWeight(0);
           else vertex.setWeight(Integer.MAX_VALUE);
       }
       /**
       * Step 2:
       *Relax all edges |V|-1 times. shortest path from source to any vertex can be found in |V|-1 iteration.
       *
       * */
       List<Edge> edges=new LinkedList<>();
       for (Vertex<V> vertex : graph.getVertices())
           edges.addAll(graph.getEdges(vertex));

       for (int i = 0; i < graph.size()-1; i++) {
           for (Edge edge : edges) {
               Integer newPath = edge.getFrom().getWeight().intValue() + edge.getWeight().intValue();
               if (edge.getFrom().getWeight().intValue() != Integer.MAX_VALUE && edge.getTo().getWeight().intValue() > newPath) {
                   edge.getTo().setWeight(newPath);
                   edge.getTo().setParent(edge.getFrom());
               }
           }
       }
       /**
        * Step 3 :
        * check negative cycle
        * the above guarantees shortest path, if there another shortest path found that means
        * there is a negative cycle
        * */
       for (Edge edge : edges) {
           Integer newPath = edge.getFrom().getWeight().intValue() + edge.getWeight().intValue();
           if (edge.getFrom().getWeight().intValue() != Integer.MAX_VALUE && edge.getTo().getWeight().intValue() > newPath) {
               System.out.println("Negative Cycle found");
               break;
           }
       }

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
