package timus;

import java.util.*;

/**
 * Created by sherxon on 11/22/16.
 */
public class IsenbaevNumber1837 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        IGraph graph= new IGraph();
        int n=Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String[] s=in.nextLine().split(" ");

            graph.addVertex(s[0]);
            graph.addVertex(s[1]);
            graph.addVertex(s[2]);

            graph.addEdge(s[0], s[1]);
            graph.addEdge(s[1], s[2]);
            graph.addEdge(s[0], s[2]);

        }
        if(n>0 && graph.vertices.get("Isenbaev")!=null){
            graph.bfs(graph.vertices.get("Isenbaev"), new LinkedList<>());
        }
        graph.print();

    }

    public static class IGraph{
        Map<IVertex, HashSet<IVertex>> map= new HashMap<>();
        Map<String, IVertex> vertices= new HashMap<>();

        public void addVertex(String v){
            vertices.putIfAbsent(v, new IVertex(v));
            map.putIfAbsent(vertices.get(v), new HashSet<>());
        }
        public void addVertex(IVertex v){
            map.putIfAbsent(v, new HashSet<>());
        }
        public void addEdge(String v1, String v2){
            map.get(vertices.get(v1)).add(vertices.get(v2));
            map.get(vertices.get(v2)).add(vertices.get(v1));
        }
        public void bfs(IVertex vertex, Queue<IVertex> queue){
            vertex.visited=true;
            queue.add(vertex);
            while (!queue.isEmpty()){
                IVertex current=queue.remove();
                for (IVertex iVertex : map.get(current)) {
                    if(!iVertex.visited){
                        iVertex.visited=true;
                        iVertex.num=current.num+1;
                        queue.add(iVertex);
                    }
                }
            }
        }

        public void print() {
            List<IVertex> list= new ArrayList<>(map.keySet());
            Collections.sort(list, (a, b) -> a.elem.compareTo(b.elem));
            for (IVertex vertex : list) {
                if(vertex.num == 0 && !"Isenbaev".equals(vertex.elem))
                    System.out.println(vertex.elem +  " undefined");
                else
                    System.out.println(vertex.elem +  " " + vertex.num);
            }
        }

        private static class IVertex{
            private  String elem;
            private int num;
            private boolean visited;
            public IVertex(String elem) {
                this.elem = elem;
            }

            public IVertex() {
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                IVertex vertex = (IVertex) o;

                return elem.equals(vertex.elem);

            }

            @Override
            public int hashCode() {
                return elem.hashCode();
            }
        }


    }
}
