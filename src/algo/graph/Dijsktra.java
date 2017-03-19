package algo.graph;

import ds.graph.Edge;
import ds.graph.Vertex;
import ds.graph.WeightedGraph;

import java.util.TreeSet;

/**
 * Created by sherxon on 1/7/17.
 */
/**
* This is the algorithm to find shortest Path in weighted and non-negative edged graph. Graph can be directed
* or undirected. This is not optimized version as shortestPath() method searches vertex with minimal weight
* every time. To optimize fibonacci heap can be used. This algorithm finds shortest path from source vertex
* to all other reachable vertexes. Time complexity is O(VE)
* */
public class Dijsktra<V, E extends Number> {
    WeightedGraph<V, E> graph;

    public Dijsktra(WeightedGraph<V, E> graph) {
        this.graph = graph;
    }


    public void printPath(V h) {
        Vertex<V> root=graph.getVertex(h);
        if(root==null)return;
        while (root.getParent()!=null){
            System.out.print(root.getValue() + " " + root.getWeight() + " ");
            root=root.getParent();
        }
        System.out.println("a 0");
    }

    public void shortestPath(V a) {
        Vertex<V> source=graph.getVertex(a);
        TreeSet<Vertex<V>> priorityQueue = new TreeSet<>();
        for (Vertex<V> vertex : graph.getVertices()) {
            if(source==vertex)vertex.setWeight(0);
            else vertex.setWeight(Integer.MAX_VALUE);
            priorityQueue.add(vertex);
        }
        while (!priorityQueue.isEmpty()) {
            Vertex<V> min = priorityQueue.pollFirst();
            min.setVisited(true);// why needed?
            for (Edge<E> edge : graph.getEdges(min.getValue())) { // TODO vertexes may have the same value
                Integer newPath=min.getWeight() +edge.getWeight().intValue();
                if(edge.getTo().getWeight() > newPath){
                    priorityQueue.remove(edge.getTo());
                    edge.getTo().setWeight(newPath);
                    edge.getTo().setParent(min);
                    priorityQueue.add(edge.getTo()); // TODO haha fix this problem even IDEA found this problem
                }
            }
        }


    }


}
