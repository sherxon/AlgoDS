package ds.graph.vertexcover;

import ds.graph.Edge;
import ds.graph.Graph;
import ds.graph.UndirectedGraph;
import ds.graph.Vertex;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by sherxon on 3/21/17.
 */
public class PolynomialSolutionForVertexCover {
    public static void main(String[] args) {

        int ran = (int) (Math.random() * 100);
        System.out.println("number of graphs: " + ran);
        for (int i = 0; i < ran; i++) {
            System.out.println("-----------------------------------------------");
            Graph<Integer, Number> graph = new UndirectedGraph<>();
            Graph<Integer, Number> graphForBrute = new UndirectedGraph<>();
            int randomVertexNum = ThreadLocalRandom.current().nextInt(1, 10);
            System.out.println("number of vertices: " + randomVertexNum);
            for (int j = 0; j < randomVertexNum; j++) {
                graph.addVertex(j);
                graphForBrute.addVertex(j);
            }

            int numOfEdge = ThreadLocalRandom.current().nextInt(randomVertexNum);
            System.out.println("number of edges: " + numOfEdge);
            for (int j = 0; j < numOfEdge; j++) {
                int from = (int) (Math.random() * randomVertexNum);
                int to = (int) (Math.random() * randomVertexNum);
                graph.addEdge(from, to);
                graphForBrute.addEdge(from, to);
            }
            Set<Vertex<Integer>> bruteSolution = getSolutionBrute(graphForBrute);
            Set<Vertex<Integer>> mySolution = new HashSet<>();
            try {
                mySolution = getSolution(graph);
            } catch (Exception e) {
                System.out.println(graph);
            }
            System.out.println("MySolution: " + mySolution.size() + " BruteSOlution: " + bruteSolution.size());
            // check solutions
            if (mySolution.size() != bruteSolution.size()) {
                System.out.println("###############################################################################");
                System.out.println("NOT EQUAL ");
                System.out.println("isMinCover => " + isMinVCover(mySolution, graph));
                System.out.println(mySolution);
                System.out.println(bruteSolution);
                System.out.println(graph.getEdges());
            } else {
                System.out.println("isMinCover => " + isMinVCover(mySolution, graph));
            }
            System.out.println("------------------------------------------");
        }
    }

    private static Set<Vertex<Integer>> getSolutionBrute(Graph<Integer, Number> graph) {
        Set<Vertex<Integer>> set = new HashSet<>();
        List<Set<Vertex<Integer>>> powerSet = getPowerSet(new ArrayList<>(graph.getVertices()));
        Collections.sort(powerSet, (a, b) -> a.size() - b.size());
        for (Set<Vertex<Integer>> vertexes : powerSet) {
            if (isMinVCover(vertexes, graph)) {
                return new HashSet<>(vertexes);
            }
        }
        return set;
    }

    private static List<Set<Vertex<Integer>>> getPowerSet(List<Vertex<Integer>> vertices) {
        List<Set<Vertex<Integer>>> lists = new ArrayList<>();
        boolean[] a = new boolean[vertices.size()];
        getPerm(vertices, a, lists, vertices.size());
        System.out.println("Size of subsets: " + lists.size());
        return lists;
    }

    private static void getPerm(List<Vertex<Integer>> vertices, boolean[] a, List<Set<Vertex<Integer>>> lists, int size) {
        if (size == 0) {
            Set<Vertex<Integer>> l = new HashSet<>();
            for (int i = 0; i < a.length; i++)
                if (a[i]) l.add(vertices.get(i));
            lists.add(l);
        } else {
            a[size - 1] = true;
            getPerm(vertices, a, lists, size - 1);

            a[size - 1] = false;
            getPerm(vertices, a, lists, size - 1);
        }
    }

    private static boolean isMinVCover(Set<Vertex<Integer>> set, Graph<Integer, Number> graph) {

        for (Edge<Number, Integer> edge : graph.getEdges()) {
            if (!set.contains(edge.getTo()) && !set.contains(edge.getFrom())) return false;
        }
        return true;
    }

    private static Set<Vertex<Integer>> getSolution(Graph<Integer, Number> graph) {
        Set<Vertex<Integer>> set = new HashSet<>();
        Vertex<Integer> maxDegree = getMaxDegreeVertex(graph);
        while (maxDegree != null) {
            set.add(maxDegree);
            graph.removeVertex(maxDegree.getValue());
            maxDegree = getMaxDegreeVertex(graph);
        }
        return set;
    }

    private static Vertex<Integer> getMaxDegreeVertex(Graph<Integer, Number> graph) {
        Vertex<Integer> maxVer = null;
        int max = 0;
        for (Vertex<Integer> integerVertex : graph.getVertices()) {
            if (integerVertex.getNeighbors().size() > max) {
                max = integerVertex.getNeighbors().size();
                maxVer = integerVertex;
            }
        }
        return maxVer;
    }
}
