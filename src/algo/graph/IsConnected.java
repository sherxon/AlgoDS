package algo.graph;

import ds.graph.Graph;

import java.util.Set;

/**
 * Created by sherxon on 4/16/17.
 */
/**
* To find If given graph connected or not, we do dfs and compare all visited nodes during dfs with graph's
* vertices if they are the same set of vertices, it means the graphs is connected. Running time is the same as
* DFS.
* */
public class IsConnected extends DFS{
    Graph graph;

    public IsConnected(Graph graph) {
        super(graph);
        this.graph=graph;
    }

    public boolean isConnected(){
        search(1); // any random vertex

        Set<Integer> graphVertices=graph.getVertices();

        if(graphVertices.size()!=visited.size())return false;

        for (Integer integer : graph.getVertices()) {
            if(!visited.contains(integer)) return false;
        }
        return true;
    }

}
