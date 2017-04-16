package algo.graph;

import ds.graph.Graph;

import java.util.*;

/**
 * Created by sherxon on 1/4/17.
 */
public class DFS {
    protected Graph graph;
    protected Set<Integer> visited;
    protected List<Integer> path;

    public DFS(Graph graph) {
        this.graph = graph;
        visited = new HashSet<>();
        path = new LinkedList<>();
    }

    public void search(Integer source) {

        visited.add(source);
        processVertex(source);

        for (Integer neighbor : graph.getNeighbors(source))
            if (!visited.contains(neighbor)) {
                search(neighbor);
            }
    }

    public void processVertex(Integer source) {
        path.add(source);
    }

    public void searchIterative(Integer source) {
        if (source == null || !graph.getVertices().contains(source)) return;

        visited.clear();
        path.clear();

        Stack<Integer> stack = new Stack<>();
        stack.add(source);

        while (!stack.isEmpty()){
            Integer v = stack.pop();

            visited.add(v);
            processVertex(v);

            for (Integer neighbor : graph.getNeighbors(v)) {
                if (!visited.contains(neighbor))
                    stack.add(neighbor);
            }
        }

    }


    public List<Integer> getPathFrom(Integer source) {

        if (source == null || !graph.getVertices().contains(source))
            return null;
        search(source);
        return path;
    }


}
