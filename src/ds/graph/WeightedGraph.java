package ds.graph;

import java.util.*;

/**
 * Created by sherxon on 1/7/17.
 */
public class WeightedGraph<V, E extends Number>{


   private  boolean Undirected = false;
   private Map<V, Vertex<V>> map= new HashMap<>();
    private Map<Vertex<V>, Set<Edge<E, V>>> edges = new HashMap<>();

    public WeightedGraph(boolean Undirected) {
        this.Undirected = Undirected;
    }

    public void addVertex(V v) {
        map.put(v, new Vertex<>(v));
        edges.put(map.get(v), new HashSet<>());
    }

    public void addEdge(V v1, V v2, E weight) {
        if(!map.containsKey(v1))return;
        if(!map.containsKey(v2))return;
        Edge<E, V> edge = new Edge<>(weight, map.get(v1), map.get(v2));

        edges.get(map.get(v1)).add(edge);

        if(Undirected) {
            Edge<E, V> edge2 = new Edge<>(weight, map.get(v2), map.get(v1));
            edges.get(map.get(v2)).add(edge2);
        }
    }

    public void removeVertex(V v) {

    }

    public void removeEdge(V t1, V t2) {

    }


    public Collection<Vertex<V>> getVertices() {
        return map.values();
    }

    public Set<Edge<E, V>> getEdges(Vertex<V> v) {
        return edges.get(v);
    }

    public int size() {
        return map.size();
    }

    public Vertex<V> getVertex(V v) {
        return map.get(v);
    }
}
