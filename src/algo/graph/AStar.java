package algo.graph;

import ds.graph.Edge;
import ds.graph.Vertex;
import ds.graph.WeightedGraph;

import java.util.*;

/**
 * Created by sherxon on 3/24/17.
 */
public class AStar<V, E extends Number> {

    private WeightedGraph<V, E> graph;

    public AStar(WeightedGraph<V, E> graph) {
        this.graph = graph;
    }

    public List<Vertex> aStarSearch(Vertex<V> start, Vertex<V> goal) {
        Map<Vertex, Vertex> parent = new HashMap<>();
        Map<Vertex, Double> distance = new HashMap<>();
        Set<Vertex<V>> openSet = new HashSet<>();
        Set<Vertex<V>> closedSet = new HashSet<>();
        distance.put(start, 0.0);
        openSet.add(start);

        while (!openSet.isEmpty()) {
            Vertex<V> current = null;
            double min = Double.MAX_VALUE;
            for (Vertex<V> point : openSet) {
                if (distance.get(point) < min) {
                    current = point;
                    min = distance.get(point);
                }
            }
            //nodeSearched.accept(current);
            if (goal.equals(current))
                return makePath(start, goal, parent);

            openSet.remove(current);
            closedSet.add(current);

            for (Edge<E, V> edge : graph.getEdges(current)) {
                if (closedSet.contains(edge.getTo())) continue;

                double nextDistance = (distance.get(current) + edge.getWeight().doubleValue());
                double heuristicDist = nextDistance + heuristicDistance(goal, edge.getTo());

                if (heuristicDist < distance.getOrDefault(edge.getTo(), Double.MAX_VALUE)) {
                    distance.put(edge.getTo(), heuristicDist);
                    parent.put(edge.getTo(), current);
                    openSet.add(edge.getTo());
                }
            }
        }
        List<Vertex> list = makePath(start, goal, parent);
        return list.size() <= 1 ? null : list;
    }

    private double heuristicDistance(Vertex<V> goal, Vertex to) {
        /**
         * We should use one of the distance calculation according to data
         * 1) Manhattan
         * 2) Euclidean
         * 3) Octile
         * 4) Chebyshev
         * */
        return 0;
    }

    private List<Vertex> makePath(Vertex start, Vertex goal,
                                  Map<Vertex, Vertex> parent) {

        LinkedList<Vertex> list = new LinkedList<>();
        Vertex point = goal;
        while (point != null) {
            list.addFirst(point);
            point = parent.get(point);
        }
        return list;
    }
}
