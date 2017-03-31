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


        System.out.println("number of graphs: " + 100);
        for (int i = 0; i < 100; i++) {
            System.out.println("-----------------------------------------------");
            Graph<Integer, Number> graph = new UndirectedGraph<>();
            Graph<Integer, Number> graphForBrute = new UndirectedGraph<>();
            int randomVertexNum = ThreadLocalRandom.current().nextInt(2, 20);
            System.out.println("number of vertices: " + randomVertexNum);
            for (int j = 0; j < randomVertexNum; j++) {
                graph.addVertex(j);
                graphForBrute.addVertex(j);
            }

            int numOfEdge = ThreadLocalRandom.current().nextInt(randomVertexNum * (randomVertexNum - 1) / 2);
            System.out.println("number of edges: " + numOfEdge);
            for (int j = 0; j < numOfEdge; j++) {
                int from = (int) (Math.random() * randomVertexNum);
                int to = (int) (Math.random() * randomVertexNum);
                graph.addEdge(from, to);
                graphForBrute.addEdge(from, to);
            }
            long start = System.currentTimeMillis();
            Set<Vertex<Integer>> mySolution = getSolution(graph);
            long end = System.currentTimeMillis();
            System.out.println("My Solution Takes: " + ((end - start) / 1000.0));
            start = System.currentTimeMillis();
            Set<Vertex<Integer>> bruteSolution = getSolutionBrute(graphForBrute);
            end = System.currentTimeMillis();
            System.out.println("Brute Solution Takes: " + ((end - start) / 1000.0));
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
        Comparator<Vertex<Integer>> comparator = (a, b) -> {

            if (a.getNeighbors().size() > b.getNeighbors().size()) return 1;
            else if (a.getNeighbors().size() < b.getNeighbors().size()) return -1;

            int counta = 0;
            for (Vertex<Integer> ane : a.getNeighbors()) {
                counta += ane.getNeighbors().size();
            }
            int countb = 0;
            for (Vertex<Integer> bne : b.getNeighbors()) {
                countb += bne.getNeighbors().size();
            }
            return countb - counta;
        };
        for (Vertex<Integer> integerVertex : graph.getVertices()) {
            if (maxVer == null || comparator.compare(integerVertex, maxVer) > 0) {
                maxVer = integerVertex;
            }
        }
        return maxVer == null || maxVer.getNeighbors().size() == 0 ? null : maxVer;
    }
}
