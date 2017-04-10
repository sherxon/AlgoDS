package algo.graph;

import ds.graph.Edge;
import ds.graph.WeightedGraph;

import java.util.*;

/**
 * Created by sherxon on 3/31/17.
 */

/**
 * This is Prim's greedy Minimum Spanning Tree algorithm which can be used in connected weighted graphs.
 * Algorithms starts building MST by randomly choosing one vertex. Then, we add least weighted edge from already
 * selected vertices and add its adjacent vertex to tree if it is not already in the tree.
 * Running time is O(V^2). It can be done O(E+ V logV) by using Fibonacci heap.
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
            Edge minEdge = q.remove(); // get min weighted edge
            Integer vertex = minEdge.getTo();
            if (mst.contains(vertex)) continue; // if it is already in the MST tree, ignore it

            q.addAll(graph.getEdges(vertex));

            list.add(minEdge);
            mst.add(vertex); // add this vertex to mst

        }
        return list;
    }
    /**
    * we can start any from any random vertex
    * */
    private Integer getRandomVertex() {

        if (graph.getVertices().size() > 0)
            return graph.getVertices().iterator().next();

        return null;
    }


}
