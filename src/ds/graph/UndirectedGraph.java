package ds.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sherxon on 1/1/17.
 */
public class UndirectedGraph<V> implements Graph<V> {
    private Map<V, Vertex<V>> vertexMap = new HashMap<>();
    private Collection<Edge<Integer>> edges = new ArrayList<>();

    @Override
    public void addVertex(V v) {
        vertexMap.put(v, new Vertex<>(v));
    }


    @Override
    public Collection<Vertex<V>> getVertices() {
        return vertexMap.values();
    }

    @Override
    public Collection<Edge<Integer>> getEdges() {
        return edges;
    }


    @Override
    public void addEdge(V v1, V v2) {
        if(!vertexMap.containsKey(v1))return;
        if(!vertexMap.containsKey(v2))return;
        Vertex<V> from=vertexMap.get(v1);
        Vertex<V> to=vertexMap.get(v2);
        from.addNeighbor(to);
        to.addNeighbor(from);
        edges.add(new Edge<>(0, from, to));
    }

    @Override
    public void removeVertex(V v) {

    }

    @Override
    public void removeEdge(V v1, V v2) {
        if(!vertexMap.containsKey(v1))return;
        if(!vertexMap.containsKey(v2))return;
        Vertex<V> from=vertexMap.get(v1);
        Vertex<V> to=vertexMap.get(v2);
        from.removeNeighrbor(to);
        to.removeNeighrbor(from);
    }

    @Override
    public int size() {
        return vertexMap.size();
    }

    @Override
    public Vertex<V> getVertex(V v) {
        return vertexMap.get(v);
    }
}
