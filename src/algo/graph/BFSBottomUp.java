package algo.graph;

import ds.graph.Graph;
import ds.graph.Vertex;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sherxon on 2/13/17.
 */

/**
 *
 * */
public class BFSBottomUp<T> {
    Graph<T> graph;

    public BFSBottomUp(Graph<T> graph) {
        this.graph = graph;
    }

    public void search(T source) {
        clearGraph();
        Vertex<T> current = graph.getVertex(source);
        Queue<Vertex<T>> frontier = new LinkedList<>();
        frontier.add(current);
        while (!frontier.isEmpty()) {
            Vertex<T> v = frontier.remove(); // why needed?
            for (Vertex<T> vertex : graph.getVertices()) {
                if (!vertex.isVisited()) {
                    if (frontier.contains(vertex)) {
                        vertex.setVisited(true);
                        vertex.setParent(v);
                        frontier.add(vertex);
                        break;
                    }
                }
            }
        }

    }

    private void clearGraph() {
        for (Vertex<T> vertex : graph.getVertices()) {
            vertex.setVisited(false);
            vertex.setParent(null);
        }
    }

}
