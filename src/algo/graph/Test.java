package algo.graph;

import ds.graph.DirectedGraph;
import ds.graph.Graph;
import ds.graph.WeightedGraph;

import java.util.List;

/**
 * Created by sherxon on 1/5/17.
 */
public class Test {
    public static void main(String[] args) {
        Graph<String, Number> graph = new DirectedGraph<>();
        graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");
        graph.addVertex("d");
        graph.addVertex("e");
        graph.addVertex("f");
        graph.addVertex("g");
        graph.addVertex("q");
        graph.addVertex("p");
        graph.addEdge("a", "b");
        graph.addEdge("a", "d");
        graph.addEdge("a", "c");
        graph.addEdge("b", "f");
        graph.addEdge("c", "e");
        graph.addEdge("e", "g");
        graph.addEdge("q", "p");
        TopologicalSorting<String> t= new TopologicalSorting<>(graph);
        List<String> list=t.topSort();
        System.out.println(list);


        WeightedGraph<String, Integer> weightedGraph= new WeightedGraph<>(false);
        weightedGraph.addVertex("a");
        weightedGraph.addVertex("b");
        weightedGraph.addVertex("c");
        weightedGraph.addVertex("d");
        weightedGraph.addVertex("e");
        weightedGraph.addVertex("f");
        weightedGraph.addVertex("g");
        weightedGraph.addVertex("h");
        weightedGraph.addEdge("a", "f", 1);
        weightedGraph.addEdge("a", "b", 2);
        weightedGraph.addEdge("b", "g", 23);
        weightedGraph.addEdge("b", "d", 4);
        weightedGraph.addEdge("c", "d", 4);
        weightedGraph.addEdge("d", "h", 2);
        weightedGraph.addEdge("e", "d", 1);
        weightedGraph.addEdge("f", "e", 3);
        weightedGraph.addEdge("g", "c", 4);
        Dijsktra<String, Integer> dijsktra= new Dijsktra<>(weightedGraph);
        //dijsktra.shortestPath("a");
        //dijsktra.printPath("h");
        BellmanFord<String, Integer> bellmanFord= new BellmanFord<>(weightedGraph);
        bellmanFord.shortestPath("a");
        bellmanFord.printPath("h");

    }
}
//h 7 d 5 e 4 f 1 a 0