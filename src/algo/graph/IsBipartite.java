package algo.graph;

import ds.graph.Graph;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sherxon on 4/1/17.
 */
public class IsBipartite extends BFS {

    private Map<Integer, Boolean> color = new HashMap<>();

    public IsBipartite(Graph graph) {
        super(graph);
    }

    /**
     * If there is a cycle with odd number of vertices, that graph cannot be bipartite. To check if graph has odd
     * cycle, we traverse the graph with bfs and paint current node with white and its children with black.
     * if any node has the same color as its parent, there is odd cycle.
     */
    boolean hasOddCycle() {
        for (Integer ver : graph.getVertices()) {
            for (Integer nei : graph.getNeighbors(ver)) {
                if (color.get(ver) == color.get(nei)) return true;
            }
        }
        return false;
    }

    @Override
    public void processVertex(Integer vertex) {
        super.processVertex(vertex);
        if (!color.containsKey(vertex))
            color.put(vertex, true); // black
        else
            color.put(vertex, !color.get(queue.peek()));
    }
}
