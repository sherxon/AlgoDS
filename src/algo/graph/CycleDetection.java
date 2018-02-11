package algo.graph;

import ds.graph.Graph;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by sherxon on 4/16/17.
 */

/**
 * To find if the given graph has cycle , We need to maintain one additional set of exited vertices and do dfs.
 * In any step if iteration if a vertex is already in visited set and yet not exited from recusion stack, then
 * we can return true. We can optimize using one array with 3 different values.
 */
public abstract class CycleDetection {
    protected Graph graph;
    protected Set<Integer> visited;
    protected Set<Integer> exited;

    public CycleDetection(Graph graph) {
        this.graph = graph;
        visited = new HashSet<>();
        exited = new HashSet<>();
    }

    public boolean hasCycle() {

        for (Integer vertex : graph.getVertices()) {
            if (!visited.contains(vertex) && !dfs(vertex))
                return false;
        }
        return true;
    }

    private boolean dfs(Integer start) {
        visited.add(start);

        for (Integer neighbor : graph.getNeighbors(start)) {

            if (visited.contains(neighbor) && !exited.contains(neighbor))
                return true;

            if (!visited.contains(neighbor) && dfs(neighbor))
                return true;
        }
        exited.add(start);
        return false;
    }
}
