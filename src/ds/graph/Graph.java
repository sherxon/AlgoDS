package ds.graph;

import java.util.Set;

/**
 * Created by sherxon on 1/1/17.
 */
public interface Graph {
     boolean addVertex(Integer t);

     Double addEdge(Integer from, Integer to);

     boolean addEdge(Integer from, Integer to, Double weight);

     boolean removeVertex(Integer t);

     boolean removeEdge(Integer from, Integer to);

     Set<Integer> getVertices();

     Set<Integer> getNeighbors(Integer ver);
     int size();
}