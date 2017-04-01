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

    Map<Integer, Integer> path = new HashMap<>();
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
        path.put(root, null);
        while (!queue.isEmpty()){
            Integer vertex = queue.remove();
            proccessVertex(vertex);
            for (Integer neighbor : graph.getNeighbors(vertex))
                if (!visited.contains(neighbor)) {
                    path.put(neighbor, vertex);
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
        }
    }

    private void proccessVertex(Integer vertex) {
        // process vertex: default not nothing;
    }


    public List<Integer> getPathFrom(Integer source, Integer sink) {
        List<Integer> list = new ArrayList<>();
        if (sink == null || !graph.getVertices().contains(sink))
            return list;

        search(source);

        Integer current = sink;
        while (path.get(current) != null) {
            list.add(current);
            current = path.get(current);
        }
        return list;
    }
}
