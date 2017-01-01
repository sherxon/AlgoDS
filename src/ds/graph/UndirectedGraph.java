package ds.graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by sherxon on 1/1/17.
 */
public class UndirectedGraph<T> implements Graph<T> {
    Map<T, Vertex<T>> vertexMap= new HashMap<>();

    @Override
    public void addVertex(T t) {
        if(vertexMap.containsKey(t))return;
        Vertex<T> vertex= new Vertex<>(t);
        vertexMap.put(t, vertex);
    }

    @Override
    public Collection<Vertex<T>> getNeighbors(T t){
        if(!vertexMap.containsKey(t))return new HashSet<>();
        return vertexMap.get(t).getNeighbors();
    }

    @Override
    public Collection<Vertex<T>> getVertices() {
        return vertexMap.values();
    }



    @Override
    public void addEdge(T t1, T t2) {
        if(!vertexMap.containsKey(t1))return;
        if(!vertexMap.containsKey(t2))return;
        Vertex<T> from=vertexMap.get(t1);
        Vertex<T> to=vertexMap.get(t2);
        from.addNeighbor(to);
        to.addNeighbor(from);
    }

    @Override
    public void removeVertex(T t) {

    }

    @Override
    public void removeEdge(T t1, T t2) {
        if(!vertexMap.containsKey(t1))return;
        if(!vertexMap.containsKey(t2))return;
        Vertex<T> from=vertexMap.get(t1);
        Vertex<T> to=vertexMap.get(t2);
        from.removeNeighrbor(to);
        to.removeNeighrbor(from);
    }

    @Override
    public int size() {
        return vertexMap.size();
    }

    @Override
    public Vertex<T> getVertex(T t) {
        return vertexMap.get(t);
    }
}
