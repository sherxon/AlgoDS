package algo.graph;

import ds.graph.DirectedGraph;
import ds.graph.Graph;

import java.util.List;

/**
 * Created by sherxon on 1/5/17.
 */
public class Test {
    public static void main(String[] args) {
        Graph<String> graph= new DirectedGraph<>();
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
    }
}
