package algo.graph;

import ds.graph.Graph;

import java.util.*;

/**
 * Created by sherxon on 1/1/17.
 */

/**
 * This is traditional top-down approach to traverse graph. This is advantageous when the frontier is small
 */
public class BFS {

    List<Integer> path = new LinkedList<>();
    private Graph graph;


    public BFS(Graph graph) {
        this.graph = graph;
    }

    public void search(Integer root) {
        if (root == null || !graph.getVertices().contains(root)) return;

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(root);
        queue.add(root);


        while (!queue.isEmpty()) {

            Integer vertex = queue.remove();
            proccessVertex(vertex);

            for (Integer neighbor : graph.getNeighbors(vertex))
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
        }
    }

    private void proccessVertex(Integer vertex) {
        path.add(vertex);
    }


    public List<Integer> getPathFrom(Integer source) {
        if (source == null || !graph.getVertices().contains(source))
            return null;
        search(source);
        return path;
    }
}
