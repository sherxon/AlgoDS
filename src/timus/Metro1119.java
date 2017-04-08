package timus;

import java.util.*;

/**
 * Created by sherxon on 2016-11-26.
 */
public class Metro1119 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt(); //col 3
        int m=in.nextInt(); //row 2
        int k=in.nextInt();
        int num=(n+1)*(m+1);
        GMetro g=new GMetro(num+1);
        for (int i = 1; i <=num; i++) {
            g.addVertex(i);
        }

         int to, from, col, row;

        for (int i = 0; i < k; i++) {
             col=in.nextInt(); //1 3 1
             row=in.nextInt(); //1 2 2
             to=col+1 +row*(n+1); //6 12
             from=to-(n+m);
            g.addEdge(from, to, Math.sqrt(20000));
        }
        for (int i = 1; i <=num; i++) {
            if( i % (n+1)!=0) {
                g.addEdge(i, i+1, 100);
            }
            g.addEdge(i, n+m-1+i, 100);
        }
        int a = g.findShortestPath(1);

        System.out.println(a);
    }
    private static class GMetro{
        Map<Integer, V> map;

        public GMetro(int num) {
            map= new HashMap<>(num);
        }

        public void addVertex(Integer v){
            V vertex= new V(v);
            map.putIfAbsent(v, vertex);
        }
        public void addEdge(Integer from, Integer to, double w){
            V fromV=map.get(from);
            V toV=map.get(to);
            if(fromV!=null && toV!=null) {
                E e= new E(fromV, toV, w);
                fromV.edges.add(e);
            }

        }

        public int findShortestPath(Integer s) {
            List<V> q= new ArrayList<>();

            for (Map.Entry<Integer, V> entry : map.entrySet()) {
                V v=entry.getValue();
                v.dest = v.label == s ? 0 : Double.MAX_VALUE;
                q.add(v);
            }

            while (!q.isEmpty()){
                V v=null;
                Double min=Double.MAX_VALUE;
                for (V v1 : q) {
                    if(min > v1.dest){
                        v=v1;
                        min=v1.dest;
                    }
                }

                if(v==null){
                    V last=map.get(map.size());
                    return (int)Math.round(last.dest);
                }
                for (E edge : v.edges) {
                    if(edge.to.dest > edge.weight+ v.dest){
                        edge.to.dest=edge.weight+v.dest;
                    }
                }
                q.remove(v);
            }
            //Double max=-1.0;
            V last=map.get(map.size());

            return (int)Math.round(last.dest);
        }

        private class V implements Comparable{
            V parent;
            List<E> edges;
            double dest;
            int label;

            public V(int label) {
                this.label = label;
                this.edges= new ArrayList<>();
            }

            @Override
            public int compareTo(Object o) {
                return (int) (this.dest - ((V)o).dest);
            }
        }
        private class E {
            V from;
            V to;
            double weight;

            public E(V from, V to, double weight) {
                this.from = from;
                this.to = to;
                this.weight = weight;
            }
        }
    }
}
