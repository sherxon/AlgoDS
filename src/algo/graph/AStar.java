package algo.graph;

import ds.graph.Edge;
import ds.graph.WeightedGraph;

import java.util.*;

/**
 * Created by sherxon on 3/24/17.
 */
public class AStar {

    private WeightedGraph graph;

    public AStar(WeightedGraph graph) {
        this.graph = graph;
    }

    public List<Integer> aStarSearch(Integer start, Integer goal) {
        Map<Integer, Integer> parent = new HashMap<>();
        Map<Integer, Double> distance = new HashMap<>();
        Set<Integer> openSet = new HashSet<>();
        Set<Integer> closedSet = new HashSet<>();
        distance.put(start, 0.0);
        openSet.add(start);

        while (!openSet.isEmpty()) {
            Integer current = null;
            double min = Double.POSITIVE_INFINITY;
            for (Integer point : openSet) {
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

            for (Edge edge : graph.getEdges(current)) {
                if (closedSet.contains(edge.getTo())) continue;

                double nextDistance = (distance.get(current) + edge.getWeight());
                double heuristicDist = nextDistance + heuristicDistance(goal, edge.getTo());

                if (heuristicDist < distance.getOrDefault(edge.getTo(), Double.POSITIVE_INFINITY)) {
                    distance.put(edge.getTo(), heuristicDist);
                    parent.put(edge.getTo(), current);
                    openSet.add(edge.getTo());
                }
            }
        }
        List<Integer> list = makePath(start, goal, parent);
        return list.size() <= 1 ? null : list;
    }

    private double heuristicDistance(Integer goal, Integer to) {
        /**
         * We should use one of the distance calculation according to data
         * 1) Manhattan
         * 2) Euclidean
         * 3) Octile
         * 4) Chebyshev
         * */
        return 0;
    }

    private List<Integer> makePath(Integer start, Integer goal,
                                   Map<Integer, Integer> parent) {

        LinkedList<Integer> list = new LinkedList<>();
        Integer point = goal;
        while (point != null) {
            list.addFirst(point);
            point = parent.get(point);
        }
        return list;
    }
}
