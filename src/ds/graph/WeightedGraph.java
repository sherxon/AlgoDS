package ds.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by sherxon on 1/7/17.
 */
public class WeightedGraph {
    Set<Edge> edges = new HashSet<>();
    private boolean Undirected = false;
    private Map<Integer, Set<Edge>> map = new HashMap<>();

    public WeightedGraph(boolean Undirected) {
        this.Undirected = Undirected;
    }

    public void addVertex(Integer v) {
        map.put(v, new HashSet<>());
    }

    public void addEdge(Integer v1, Integer v2, Double weight) {
        if(!map.containsKey(v1) || !map.containsKey(v2))return;
        
        Edge edge = new Edge(v1, v2, weight);

        map.get(v1).add(edge);
        edges.add(edge);

        if(Undirected) {
            Edge edge2 = new Edge(v2, v1, weight);
            map.get(v2).add(edge2);
            edges.add(edge2);
        }
    }


    public void removeVertex(Integer v) {

    }


    public Set<Integer> getVertices() {
        return new HashSet<>(map.keySet());
    }

    public Set<Edge> getEdges() {
        return edges;
    }

    public Set<Edge> getEdges(Integer ver) {
        return map.get(ver);
    }

    public int size() {
        return map.size();
    }
}
