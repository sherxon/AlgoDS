package algo.graph;

import ds.graph.Graph;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sherxon on 4/16/17.
 */
/**
* This is a graph with timestamps (in and out) in each vertex.
* */
public class GraphWithTimeStamp {

    protected Graph graph;
    protected Map<Integer, Integer> in;
    protected Map<Integer, Integer> out;
    int time;

    public GraphWithTimeStamp(Graph graph) {
        this.graph = graph;
        in= new HashMap<>();
        out= new HashMap<>();
    }

    protected void addTimeStamp(Integer current){
        time++;
        in.put(current, time);
        for (Integer neighbor : graph.getNeighbors(current)) {

            if(!in.containsKey(neighbor))
                addTimeStamp(neighbor);
        }
        time++;
        out.put(current, time);
    }


}
