package algo.graph;

import ds.graph.Edge;
import ds.graph.WeightedGraph;

import java.util.*;

/**
 * Created by sherxon on 1/7/17.
 * <p>
 * This is the algorithm to find shortest Path in weighted and non-negative edged graph. Graph can be directed
 * or undirected. This is not optimized version as shortestPath() method searches vertex with minimal weight
 * every time. To optimize Fibonacci heap can be used. This algorithm finds shortest path from source vertex
 * to all other reachable vertexes. Time complexity is O(VE)
 */
/**
 * This is the algorithm to find shortest Path in weighted and non-negative edged graph. Graph can be directed
 * or undirected. This is not optimized version as shortestPath() method searches vertex with minimal weight
 * every time. To optimize Fibonacci heap can be used. This algorithm finds shortest path from source vertex
 * to all other reachable vertexes. Time complexity is O(VE)
 * */

/**
 * Choosing vertex with min distance is the main factor that affects running time of this algorithms
 * 1) Using naive approach i.e.  iterating vertex and choosing vertex with nim distance O(EV)
 * 2) Binary Heaps, if decreaseKey is implemented O(E logV)
 * 3) Fibonacci Heap, O(V logV + E), impractical
 * */
public class Dijsktra {

    Map<Integer, Double> distance;
    private WeightedGraph graph;

    public Dijsktra(WeightedGraph graph) {
        this.graph = graph;
        distance = new HashMap<>();
    }

    /**
     * This is naive implementation of Dijsktra shortest path algorithm. Running time is O(VE);
     *  this implementation works best with dense graphs
     * */
    public void shortestPath(Integer source) {

        Set<Integer> openSet = new TreeSet<>();
        for (Integer vertex : graph.getVertices()) {
            if (source.equals(vertex)) distance.put(source, 0d);
            else distance.put(vertex, Double.POSITIVE_INFINITY);
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

    /**
     * This is optimized version of shortest path algorithm, whose running time is O(E logE)
     * this works better than other implementations in practise
     * */
    public void shortestPathOptimized(Integer source) {
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        Map<Integer, Pair> map = new HashMap<>();
        for (Integer vertex : graph.getVertices()) {
            Pair pair;
            if (source.equals(vertex)) pair = new Pair(vertex, 0d);
            else pair = new Pair(vertex, Double.POSITIVE_INFINITY);
            queue.add(pair);
            map.put(vertex, pair);
        }
        while (!queue.isEmpty()) {

            Pair pair = queue.remove();

            if (map.get(pair.label) != pair) continue; // if pair is already updated

            for (Edge edge : graph.getEdges(pair.label)) {
                Double newPath = pair.weight + edge.getWeight();
                if (newPath < map.get(edge.getTo()).weight) {
                    Pair newPair = new Pair(edge.getTo(), newPath);
                    map.put(edge.getTo(), newPair);
                    queue.add(newPair);
                }
            }
        }


    }

    private class Pair implements Comparable<Pair> {
        Integer label;
        Double weight;

        public Pair(Integer name, Double weight) {
            this.label = name;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair p) {
            return (int) (this.weight - p.weight);
        }
    }

}
