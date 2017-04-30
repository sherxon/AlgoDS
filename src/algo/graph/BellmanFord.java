package algo.graph;

import ds.graph.Edge;
import ds.graph.WeightedGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by sherxon on 1/7/17.
 */
/**
* This Bellman Ford shortest path algorithm. It works with negative edges and if there negative cycle
 * the algorithm reports. Time complexity is O(V*E) if E is V^2 , we can say that O(V^3).
 * This is slower than Dijkstra shortest path algorithm which works for only non-negative edges in O(VLogV)
 * with Fibonacci heap.
* */
public class BellmanFord {
    WeightedGraph graph;
    Map<Integer, Double> distance;

    public BellmanFord(WeightedGraph graph) {
        this.graph = graph;
        distance = new HashMap<>();
    }

    public void shortestPath(Integer source) {
       /**
       * Step 1:
       * Initialization  step
       * */

        for (Integer vertex : graph.getVertices()) {
            if (source.equals(vertex)) distance.put(vertex, 0d);
            else distance.put(vertex, Double.POSITIVE_INFINITY);
       }
       /**
       * Step 2:
       *Relax all edges |V|-1 times. shortest path from source to any vertex can be found in |V|-1 iteration.
       *
       * */
       List<Edge> edges=new LinkedList<>();
        for (Integer vertex : graph.getVertices())
           edges.addAll(graph.getEdges(vertex));

       for (int i = 0; i < graph.size()-1; i++) {
           for (Edge edge : edges) {
               Double newPath = distance.get(edge.getFrom()) + edge.getWeight();
               if (distance.get(edge.getTo()) > newPath) {
                   distance.put(edge.getTo(), newPath);
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
           Double newPath = distance.get(edge.getFrom()) + edge.getWeight();
           if (distance.get(edge.getTo()) > newPath) {
               System.out.println("Negative Cycle found");
               break;
           }
       }

   }
}
