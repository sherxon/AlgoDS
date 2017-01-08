package ds.graph;

import java.util.*;

/**
 * Created by sherxon on 1/7/17.
 */
public class WeightedGraph<V, E extends Number>{


   private  boolean Undirected = false;
   private Map<V, Vertex<V>> map= new HashMap<>();
   private Map<V, Set<Edge<E>>> edges= new HashMap<>();

    public WeightedGraph(boolean Undirected) {
        this.Undirected = Undirected;
    }

    public void addVertex(V v) {
        map.put(v, new Vertex<>(v));
        edges.put(v, new HashSet<Edge<E>>());
    }

    public void addEdge(V v1, V v2, E weight) {
        if(!map.containsKey(v1))return;
        if(!map.containsKey(v2))return;
        Edge<E> edge=new Edge<>(weight, map.get(v1), map.get(v2));

        edges.get(v1).add(edge);

        if(Undirected) {
            Edge<E> edge2=new Edge<>(weight, map.get(v2), map.get(v1));
            edges.get(v2).add(edge2);
        }
    }

    public void removeVertex(V v) {

    }

    public void removeEdge(V t1, V t2) {

    }


    public Collection<Vertex<V>> getVertices() {
        return map.values();
    }
    public Set<Edge<E>> getEdges(V v) {
        return edges.get(v);
    }

    public int size() {
        return map.size();
    }

    public Vertex<V> getVertex(V v) {
        return map.get(v);
    }
}
