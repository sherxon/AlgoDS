package contests.facebookHC;

import java.io.*;
import java.util.*;

/**
 * Created by sherxon on 1/14/17.
 */
public class ManicMoving {
    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int t = reader.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = reader.nextInt();
            int m = reader.nextInt();
            int k = reader.nextInt();
            long cost = 0;
            int current = 1;
            Graph graph = new Graph();
            for (int j = 0; j < m; j++)
                graph.addEdge(reader.nextInt(), reader.nextInt(), reader.nextInt());

            if (!graph.map.containsKey(current) || graph.map.get(current).isEmpty()) {
                cost = -1;// need to print and continue;
            }
            Map<Integer, int[]> moving = new LinkedHashMap<>(k);

            boolean a = true;
            for (int j = 0; j < k; j++) {
                int from = reader.nextInt();
                int to = reader.nextInt();

                if (!graph.map.containsKey(from) || graph.map.get(from).isEmpty() || !graph.map.containsKey(to) || graph.map.get(to).isEmpty()) {
                    cost = -1;
                    System.out.println("Case #" + i + ": " + cost);
                    a = false;
                    break;
                }
                moving.put(j, new int[]{from, to});
            }
            if (!a) continue;
            Map<Integer, Integer> currentToFrom = new HashMap<>();
            long currenttofrom = graph.shortestPath(current, moving.get(0)[0], currentToFrom);
            cost += currenttofrom;
            current = moving.get(0)[0];
            Set<Integer> done = new HashSet<>();
            for (Integer kf : moving.keySet()) {
                if (done.contains(kf)) continue;
                int pair[] = moving.get(kf);
                if (pair[0] != current) {
                    currentToFrom = new HashMap<>();
                    currenttofrom = graph.shortestPath(current, pair[0], currentToFrom);
                    cost += currenttofrom;
                }
                Map<Integer, Integer> fromToPath = new HashMap<>();
                long fromto = graph.shortestPath(pair[0], pair[1], fromToPath);
                cost += fromto;
                current = pair[1];
                if (moving.get(kf + 1) != null) {
                    int[] costAndCur = getPath(fromToPath, pair, moving.get(kf + 1), kf + 1, graph);
                    current = costAndCur[0];
                    cost += costAndCur[1];
                    done.add(costAndCur[2]);
                }

            }
            System.out.println("Case #" + i + ": " + cost);
        }

    }

    private static int[] getPath(Map<Integer, Integer> fromToPath, int[] pair,
                                 int[] moving, int kf, Graph graph) {

        int addcost = Integer.MAX_VALUE;
        boolean isbelong = belong(fromToPath, moving[0], moving[1]);
        if (isbelong) {
            long temp = graph.shortestPath(pair[1], moving[1], new HashMap<>());
            if (temp < addcost) {
                addcost = (int) temp;
            }
        }
        int[] res = new int[3];

        if (addcost != Integer.MAX_VALUE) {
            int cur = moving[1];
            res[0] = cur;
            res[1] = addcost;
            res[2] = kf;
            return res;
        }
        res[0] = pair[1];
        res[2] = -1;
        return res;

    }

    private static boolean belong(Map<Integer, Integer> fromToPath, int fromk, int tok) {
        int to = tok;
        while (fromToPath.get(tok) != null && (to = fromToPath.get(to)) != 0) {
            if (to == fromk) return true;
        }

        return false;
    }

    private static void write(String s) {
        File output = new File("src/contests/outround1test2.txt");
        try {
            BufferedWriter writer = new BufferedWriter(new PrintWriter(output));
            writer.write(s);
            writer.flush();
            writer.close();
            System.out.println("done");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Graph {
        Map<Integer, Set<Edge>> map = new HashMap<>();

        public void addEdge(Integer from, Integer to, int weight) {
            if (!map.containsKey(from))
                map.put(from, new HashSet<>());
            if (!map.containsKey(to))
                map.put(to, new HashSet<>());
            map.get(from).add(new Edge(weight, from, to));
            map.get(to).add(new Edge(weight, to, from));
        }

        public long shortestPath(int source, int from, Map<Integer, Integer> p) {
            if (source == from) return 0;
            Map<Integer, Integer> d = new HashMap<>();
            Set<Integer> vertices = new HashSet<>(map.keySet());
            p.put(source, 0);
            d.put(source, 0);
            while (!vertices.isEmpty()) {
                Integer min = source;
                int minValue = Integer.MAX_VALUE;
                for (Integer vertice : vertices)
                    if (d.containsKey(vertice) && minValue > d.get(vertice)) {
                        minValue = d.get(vertice);
                        min = vertice;
                    }
                vertices.remove(min);
                for (Edge edge : map.get(min)) {
                    int l = edge.weight + d.get(min);
                    if (!d.containsKey(edge.to) || d.get(edge.to) > l) {
                        d.put(edge.to, l);
                        p.put(edge.to, min);
                    }
//                    if(edge.to.equals(from)){
//                        vertices.clear();
//                        break;
//                    }
                }
            }

            return d.get(from);
        }
    }

    private static class Edge {
        int weight;
        Integer from;
        Integer to;

        public Edge(int weight) {
            this.weight = weight;
        }

        public Edge(int weight, Integer from, Integer to) {
            this.weight = weight;
            this.from = from;
            this.to = to;
        }
    }

    private static class FastReader {
        BufferedReader bf;
        StringTokenizer st;


        public FastReader() {
            bf = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextLine() {
            String st = "";
            try {
                st = bf.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return st;
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(bf.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
