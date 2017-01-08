package algo.graph;

import ds.graph.Edge;
import ds.graph.Vertex;
import ds.graph.WeightedGraph;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sherxon on 1/7/17.
 */
public class Dijsktra<V, E extends Number> {
    WeightedGraph<V, E> graph;

    public Dijsktra(WeightedGraph<V, E> graph) {
        this.graph = graph;
    }

    public static void main(String[] args) {
        WeightedGraph<String, Integer> graph= new WeightedGraph<>(true);
        graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");
        graph.addVertex("d");
        graph.addVertex("e");
        graph.addVertex("f");
        graph.addVertex("g");
        graph.addVertex("h");
        graph.addEdge("a", "f", 1);
        graph.addEdge("a", "b", 2);
        graph.addEdge("b", "g", 23);
        graph.addEdge("b", "d", 4);
        graph.addEdge("c", "d", 4);
        graph.addEdge("d", "h", 2);
        graph.addEdge("e", "d", 1);
        graph.addEdge("f", "e", 3);
        graph.addEdge("g", "c", 4);
        Dijsktra<String, Integer> dijsktra= new Dijsktra<>(graph);
        dijsktra.shortestPath("a");
        dijsktra.printPath("g");
    }

    private void printPath(V h) {
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
