package algo.graph;

import ds.graph.Edge;
import ds.graph.WeightedGraph;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by sherxon on 1/7/17.
 */
/**
* This is the algorithm to find shortest Path in weighted and non-negative edged graph. Graph can be directed
* or undirected. This is not optimized version as shortestPath() method searches vertex with minimal weight
* every time. To optimize Fibonacci heap can be used. This algorithm finds shortest path from source vertex
* to all other reachable vertexes. Time complexity is O(VE)
* */
public class Dijsktra {
    Map<Integer, Double> distance;
    private WeightedGraph graph;

    public Dijsktra(WeightedGraph graph) {
        this.graph = graph;
        distance = new HashMap<>();
    }

    public void shortestPath(Integer source) {

        Set<Integer> openSet = new TreeSet<>();
        for (Integer vertex : graph.getVertices()) {
            if (source.equals(vertex)) distance.put(source, 0d);
            else distance.put(source, Double.POSITIVE_INFINITY);
            openSet.add(vertex);
        }
        while (!openSet.isEmpty()) {

            Integer min = 0;
            double minDis = Double.POSITIVE_INFINITY;
            for (Integer vertex : openSet) {
                if (minDis > distance.get(vertex)) {
                    minDis = distance.get(vertex);
                    min = vertex;
                }
            }

            openSet.remove(min);

            for (Edge edge : graph.getEdges(min)) {

                Double newPath = distance.get(min) + edge.getWeight();
                if (distance.get(edge.getTo()) > newPath) {
                    distance.put(edge.getTo(), newPath);
                }
            }
        }


    }


}
