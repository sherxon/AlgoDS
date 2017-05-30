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
    Map<Integer, Integer> parent = new HashMap<>();

    public BFSHelper(Graph graph, Integer source) {
        queue.add(source);
        visited.add(source);
        this.graph=graph;
        parent.put(source, null);
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
                    parent.put(nei, current);
                }
            }
        }
        return new HashSet<>(queue);
    }

    List<Integer> getPath(Integer from) {
        List<Integer> list = new ArrayList<>();
        while (from != null) {
            list.add(from);
            from = parent.get(from);
        }
        return list;
    }
}
