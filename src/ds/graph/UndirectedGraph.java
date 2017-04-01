package ds.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by sherxon on 1/1/17.
 */
public class UndirectedGraph<V, E extends Number> implements Graph<V, E> {
    private Map<V, Vertex<V>> vertexMap = new HashMap<>();


    @Override
    public void addVertex(V v) {
        vertexMap.put(v, new Vertex<>(v));
    }


    @Override
    public Set<Vertex<V>> getVertices() {
        return new HashSet<>(vertexMap.values());
    }


    @Override
    public void addEdge(V v1, V v2) {
        if(!vertexMap.containsKey(v1))return;
        if(!vertexMap.containsKey(v2))return;
        Vertex<V> from=vertexMap.get(v1);
        Vertex<V> to=vertexMap.get(v2);
        if (from == to) return;
        if (from.getNeighbors().contains(to) || to.getNeighbors().contains(from)) return;
        from.addNeighbor(to);
        to.addNeighbor(from);
    }

    @Override
    public void addEdge(V v1, V v2, E weight) {
        // not supported
        // use weighted graph
    }

    @Override
    public void removeVertex(V v) {
        Vertex<V> vertex = vertexMap.get(v);
        Set<Vertex<V>> neis = vertex.getNeighbors();
        for (Vertex<V> nei : neis) {
            nei.removeNeighrbor(vertex);
        }

        vertex.getNeighbors().clear();
        vertexMap.remove(v);
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
