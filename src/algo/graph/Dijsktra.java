package algo.graph;

import ds.graph.Edge;
import ds.graph.Vertex;
import ds.graph.WeightedGraph;

import java.util.HashSet;
import java.util.Set;

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
        Set<Vertex<V>> set= new HashSet<>();
        for (Vertex<V> vertex : graph.getVertices()) {
            if(source==vertex)vertex.setWeight(0);
            else vertex.setWeight(Integer.MAX_VALUE);
            set.add(vertex);
        }
        while (!set.isEmpty()){
            Vertex<V> min=source;
            int minValue=Integer.MAX_VALUE;
            for (Vertex<V> vertex : set)
                if(minValue > vertex.getWeight()){
                    min=vertex;
                    minValue=vertex.getWeight();
                }
            set.remove(min);
            min.setVisited(true);
            for (Edge<E> edge : graph.getEdges(min.getValue())) {
                Integer newPath=min.getWeight() +edge.getWeight().intValue();
                if(edge.getTo().getWeight() > newPath){
                    edge.getTo().setWeight(newPath);
                    edge.getTo().setParent(min);
                }
            }
        }


    }


}
