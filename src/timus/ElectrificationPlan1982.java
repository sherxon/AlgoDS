package timus;

import java.util.*;

/**
 * Created by sherxon on 2016-11-24.
 */
public class ElectrificationPlan1982 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String[] f=in.nextLine().split(" ");

        int n = Integer.parseInt(f[0]);
        int k = Integer.parseInt(f[1]);

        Set<Integer> cities = new HashSet<>(k);
        String[] s=in.nextLine().split(" ");

        for (int i = 0; i < s.length; i++) {
            cities.add(Integer.parseInt(s[i]));
        }

        EGraph graph= new EGraph();

        for (int i = 1; i <=n; i++) {
            graph.addVertex(i, cities.contains(i));
        }

        String[] a;
        for (int i = 0; i < n; i++) {
            a=in.nextLine().split(" ");
            for (int j = i+1; j <a.length ; j++) {
                graph.addEdge(i+1, j+1, Integer.parseInt(a[j]));
            }
        }
        System.out.println(graph.mst());
    }

    private static class EGraph {

        public int mst(){


            List<Integer> unvisited= new ArrayList<>(map.keySet());
            Integer vertex=unvisited.get(0);
            unvisited.remove(vertex);

            PriorityQueue<VE> queue=new PriorityQueue<>();
            while (!unvisited.isEmpty()){
               VE v=map.get(vertex);
                for (EEdge outEdge : v.outEdges) {
                     if(  outEdge.to.des > outEdge.weight+ v.des){
                        outEdge.to.des=outEdge.weight+ v.des;
                         queue.add(outEdge.to);
                    }else if(outEdge.to.isPS && outEdge.from.des > outEdge.weight){
                         outEdge.from.des=outEdge.weight;
                         queue.add(outEdge.to);
                         queue.add(outEdge.from);
                     }
                }

                if(queue.size()==0)break;
                VE minVertex = queue.remove();
                unvisited.remove(minVertex.label);
                vertex=minVertex.label;
            }

            int cost=0;
            for (Integer integer : map.keySet()) {
                cost+=map.get(integer).des;
            }
            return cost;

        }


        private Map<Integer, VE> map = new HashMap<>();

        public void addVertex(Integer v, boolean contains){
            VE ve=new VE(v);
            ve.isPS=contains;
            if(contains)ve.des=0;
            else ve.des=Integer.MAX_VALUE;
            map.putIfAbsent(v,ve);
        }

        public void addEdge(Integer f, Integer t, int weight){
            VE from=map.get(f);
            VE to=map.get(t);
            if(from.isPS && to.isPS)return;

            EEdge edge= new EEdge(from, to, weight);
            map.get(f).outEdges.add(edge);

            EEdge edge2= new EEdge(to, from, weight);
            map.get(t).outEdges.add(edge2);

            map.get(f).inEdges.add(edge2);
            map.get(t).inEdges.add(edge);
        }


        private class VE implements Comparable {
            private Integer label;
            private List<EEdge> inEdges;
            private List<EEdge> outEdges;
            private boolean isPS;
            public boolean visited;
            public int des;

            public VE(Integer label) {
                this.label = label;
                this.inEdges=new ArrayList<>();
                this.outEdges=new ArrayList<>();
            }

            @Override
            public int compareTo(Object o) {
                return this.des - ((VE)o).des;
            }
        }


         static class EEdge implements Comparable{
            VE from;
            VE to;
            int weight;

            public EEdge(int weight) {
                this.weight = weight;
            }

            public EEdge(VE from, VE to, int weight) {
                this.from = from;
                this.to = to;
                this.weight = weight;
            }

            @Override
            public int compareTo(Object o) {
                return this.weight - ((EEdge)o).weight;
            }
        }
    }

}
