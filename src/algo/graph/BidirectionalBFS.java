package algo.graph;

import ds.graph.Graph;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Created by sherxon on 5/16/17.
 */
public class BidirectionalBFS{

    public static void main(String[] args) throws IOException {
        System.out.println();
    }

    List<Integer> searchBi(Graph graph, Integer source, Integer dest){
        BFSHelper sourceData=new BFSHelper(graph, source);
        BFSHelper destData=new BFSHelper(graph, dest);

        while (!sourceData.isDone() || !destData.isDone()){
             Set<Integer> frontierSource=sourceData.searchLevel();
             Set<Integer> frontierDest=destData.searchLevel();
            for (Integer integer : frontierDest) {
                if(frontierSource.contains(integer))
                    return mergePath(sourceData, destData, integer);
            }
        }
        return null;
    }

    private List<Integer> mergePath(BFSHelper sourceData, BFSHelper destData, Integer integer) {

        return null;
    }

}
