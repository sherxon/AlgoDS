package timus;

import java.util.*;

/**
 * Created by sherxon on 11/26/16.
 */
public class GenealogicalTree {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        G g= new G();
        Set<Integer> roots= new TreeSet<>((a, b)->b.compareTo(a));
        for (int i = 1; i <=n; i++) {
            g.addVertex(i);
            roots.add(i);
        }
        int child=-1;
        for (int i = 1; i <=n;) {
            child=in.nextInt();
            if(child==0){
                i++;
            }else{
                roots.remove(Integer.valueOf(child));
                g.addEdge(i,child, 0);
            }
        }


        g.reset();
        Stack<Integer> stack= new Stack<>();
        for (Integer root : roots) {
            topSort(g, root, stack);
        }
        while (!stack.empty())
            System.out.print(stack.pop() + " ");
        System.out.println();

    }

    public static void topSort(G graph, Integer start, Stack<Integer> list){
        G.V vertex=graph.vertices.get(start);

        vertex.visited=true;
        if(vertex.edges.size()>0){
            for (G.E edge : vertex.edges) {
                if(!edge.to.visited) {
                    topSort(graph, edge.to.label, list);
                }
            }
        }
        list.add(vertex.label);
    }
    private static class G{
        private Map<Integer, V> vertices= new LinkedHashMap<>();

        public void addVertex(Integer v){
            V newV= new V(v);
            vertices.putIfAbsent(v, newV);
        }
        public void addEdge(Integer from, Integer to, int weigth){
            V fromV=vertices.get(from);
            V toV=vertices.get(to);
            E e= new E(fromV, toV, weigth);
            fromV.edges.add(e); // directed graph
        }

        public void reset() {
            vertices.values().stream().forEach(s->s.visited=false);
        }


        public class V implements Comparable{
            List<E> edges= new ArrayList<>();
            private Integer label;
            int distance;
            V parent;
            boolean visited;


            public V(Integer label) {
                this.label = label;
                this.distance=0;
            }

            @Override
            public int compareTo(Object o) {
                return this.distance - ((V)o).distance;
            }
        }

        private  class E{
            V from;
            V to;
            int weight;

            public E(V from, V to, int weight) {
                this.from = from;
                this.to = to;
                this.weight = weight;
            }
        }
    }
}
