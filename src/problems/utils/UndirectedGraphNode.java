package problems.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sherxon on 1/5/17.
 */
public class UndirectedGraphNode {
   public int label;
   public List<UndirectedGraphNode> neighbors;
   public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
