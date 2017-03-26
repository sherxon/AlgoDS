package ds.graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sherxon on 1/1/17.
 */
public class DirectedGraph<V, E extends Number> implements Graph<V, E> {

   private Map<V, Vertex<V>> vertexMap= new HashMap<>();

    @Override
    public void addVertex(V v) {
        vertexMap.put(v, new Vertex<>(v));
    }


    @Override
    public Collection<Vertex<V>> getVertices() {
        return vertexMap.values();
    }

    @Override
    public Collection<Edge<E, V>> getEdges() {
        return null;
    }


    @Override
    public void addEdge(V v1, V v2) {
        if(!vertexMap.containsKey(v1))return;
        if(!vertexMap.containsKey(v2))return;
        Vertex<V> from=vertexMap.get(v1);
        from.addNeighbor(vertexMap.get(v2));
    }

    @Override
    public void removeVertex(V v) {

    }

    @Override
    public void removeEdge(V v1, V v2) {
        if(!vertexMap.containsKey(v1))return;
        if(!vertexMap.containsKey(v2))return;
        Vertex<V> from=vertexMap.get(v1);
        from.removeNeighrbor(vertexMap.get(v2));
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
