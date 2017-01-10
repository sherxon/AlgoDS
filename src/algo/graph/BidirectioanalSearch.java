package algo.graph;

import ds.graph.Vertex;
import ds.graph.WeightedGraph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sherxon on 1/9/17.
 */
public class BidirectioanalSearch<V, E extends Number> {
    WeightedGraph<V, E> graph;

    public BidirectioanalSearch(WeightedGraph<V, E> graph) {
        this.graph = graph;
    }
    boolean pathExistsBidirectional(V s, V t){
        Vertex<V> source=graph.getVertex(s);
        Vertex<V> target=graph.getVertex(t);
        Queue<Vertex<V>> queueA= new LinkedList<>();
        Queue<Vertex<V>> queueB= new LinkedList<>();
        queueA.add(source);
        queueB.add(target);
        while (!queueA.isEmpty() && !queueB.isEmpty()){

        }


        return false;
    }
}

