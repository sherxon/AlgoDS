package algo.graph;

import ds.graph.Edge;
import ds.graph.WeightedGraph;

import java.util.*;

/**
 * Created by sherxon on 3/31/17.
 */

/**
 * this only works for weighted connected graph. One can modify little to make it work for
 * graphs with many components
 */
public class PrimsMST {


    private WeightedGraph graph;

    public PrimsMST(WeightedGraph graph) {
        this.graph = graph;
    }

    public List<Edge> getMST() {
        List<Edge> list = new ArrayList<>();

        Integer start = getRandomVertex();
        if (start == null) return list;

        Set<Integer> mst = new HashSet<>();
        PriorityQueue<Edge> q = new PriorityQueue<>();
        mst.add(start);
        q.addAll(graph.getEdges(start));

        while (!q.isEmpty()) {
            Edge minEdge = q.remove();
            Integer vertex = minEdge.getTo();
            if (mst.contains(vertex)) continue;

            q.addAll(graph.getEdges(vertex));

            list.add(minEdge);
            mst.add(vertex);

        }
        return list;
    }

    private Integer getRandomVertex() {

        if (graph.getVertices().size() > 0)
            return graph.getVertices().iterator().next();

        return null;
    }


}
