package algo.graph;

import ds.graph.DirectedGraph;
import ds.graph.Graph;

/**
 * Created by sherxon on 3/31/17.
 */
public class PrimsMST {
    private Graph graph;

    public PrimsMST(Graph graph) {
        this.graph = graph;
    }

    public static void main(String[] args) {
        Graph graph = new DirectedGraph();
        for (int i = 0; i < 10; i++) graph.addVertex(i);

    }


}
