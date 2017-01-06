package algo.graph;

import ds.graph.DirectedGraph;
import ds.graph.Graph;
import ds.graph.Vertex;

import java.util.*;

/**
 * Created by sherxon on 1/4/17.
 */
public class TopologicalSorting<T> {
    private Graph<T> graph;

    public TopologicalSorting(Graph<T> graph) {
        this.graph = graph;
    }

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
    // this works with DAG Only
    // first we will choose any vertex who who does not have incoming edges (sources)
    // sources can be found easier if incoming edge count is recorded in each vertex
    List<T> topSort(){
        Stack<T> stack=new Stack<>();//stack is also good option
        Set<Vertex<T>> sources=new HashSet<>();
        for (Vertex<T> vertex : graph.getVertices())
            sources.add(vertex);
        for (Vertex<T> vertex : graph.getVertices())
            for (Vertex<T> tVertex : vertex.getNeighbors())
                sources.remove(tVertex);

        for (Vertex<T> source : sources)
            if(!source.isVisited())
                dfs(source, stack);
        return stack;
    }

    private void dfs(Vertex<T> source, List<T> list) {
        list.add(source.getValue());
        source.setVisited(true);
        for (Vertex<T> vertex : source.getNeighbors()) {
            if(!vertex.isVisited()){
                dfs(vertex, list);
            }
        }
    }
}
