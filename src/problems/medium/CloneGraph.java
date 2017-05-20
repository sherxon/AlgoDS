package problems.medium;

import problems.utils.UndirectedGraphNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sherxon on 1/5/17.
 */
public class CloneGraph {

    Map<Integer, UndirectedGraphNode> map=new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
       return cloneG(node);
    }

    private UndirectedGraphNode cloneG(UndirectedGraphNode node) {
        if(node==null)return null;
        if(map.containsKey(node.label))
            return map.get(node.label);

        UndirectedGraphNode nn= new UndirectedGraphNode(node.label);
        map.put(nn.label, nn);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            UndirectedGraphNode clone=cloneG(neighbor);
            nn.neighbors.add(clone);
        }
        return nn;
    }

}
