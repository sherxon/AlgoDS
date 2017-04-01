package ds.graph;

import java.util.Set;

/**
 * Created by sherxon on 1/1/17.
 */
public interface Graph<T, E extends Number> {
     void addVertex(T t);
     void addEdge(T t1, T t2);

     void addEdge(T v1, T v2, E weight);
     void removeVertex(T t);
     void removeEdge(T t1, T t2);
     Set<Vertex<T>> getVertices();
     Vertex<T> getVertex(T t);

     int size();


}