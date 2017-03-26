package algo.graph;

import ds.graph.Graph;
import ds.graph.Vertex;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Created by sherxon on 1/4/17.
 */
public class TopologicalSorting<T> {
    private Graph<T, Number> graph;

    public TopologicalSorting(Graph<T, Number> graph) {
        this.graph = graph;
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
        source.setVisited(true);
        for (Vertex<T> vertex : source.getNeighbors()) {
            if(!vertex.isVisited()){
                dfs(vertex, list);
            }
        }
        list.add(source.getValue());
    }
}
