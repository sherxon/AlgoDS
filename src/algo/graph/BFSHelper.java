package algo.graph;

import ds.graph.Graph;

import java.util.*;

/**
 * Created by sherxon on 5/16/17.
 */
public class BFSHelper {
    Queue<Integer> queue= new LinkedList<>();
    Graph graph;
    Set<Integer> visited=new HashSet<>();

    public BFSHelper(Graph graph, Integer source) {
        queue.add(source);
        visited.add(source);
        this.graph=graph;
    }

    public boolean isDone() {
       return queue.isEmpty();
    }

    public Set<Integer> searchLevel() {
        
        if (!queue.isEmpty()){
            Integer current=queue.remove();

            for (Integer nei : graph.getNeighbors(current)) {
                if(!visited.contains(nei)){
                    visited.add(nei);
                    queue.add(nei);
                }
            }
        }
        return new HashSet<>(queue);
    }
}
