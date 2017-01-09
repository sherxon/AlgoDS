package timus;

import java.util.*;

/**
 * Created by sherxon on 11/23/16.
 */
public class TwoTeams1106 {
    public static void main(String[] args) {

        TGraph graph= new TGraph();
        Scanner in = new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());
        for (int i = 1; i <=n ; i++)
            graph.addVertex(i);

        for (int i = 1; i <= n; i++) {
            String[] s=in.nextLine().split(" ");
            for (String s1 : s) {
                int node=Integer.parseInt(s1);
                if(node!=0)
                    graph.addEdge(i, node);
            }
        }

        for (Integer v : graph.visited.keySet()) {
            if(!graph.visited.get(v))graph.dfs(v);
        }

        System.out.println(graph.firstGroupCount);

        for (Integer vertex : graph.groups.keySet())
            if(graph.groups.get(vertex))
                System.out.print(vertex +" ");


    }
    public static class TGraph{
        Map<Integer, Set<Integer>> map= new HashMap<>();
        Map<Integer, Boolean> visited=new HashMap<>();
        Map<Integer, Boolean> groups=new HashMap<>();
        int firstGroupCount=0;

        public void addVertex(Integer v){
            map.put(v, new HashSet<>());
            visited.put(v, false);
            groups.put(v, false);
        }
        public void addEdge(Integer a, Integer b){
            map.get(a).add(b);
            map.get(b).add(a);
        }
        public void dfs(Integer start){
            visited.put(start, true);
            for (Integer integer : map.get(start)) {
                if(!visited.get(integer)){
                    visited.put(integer, true);
                    groups.put(integer, !groups.get(start));
                    firstGroupCount += groups.get(integer) ? 1 : 0;
                    dfs(integer);
                }
            }
        }

    }
}
