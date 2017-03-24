package ds.graph.vertexcover;

import ds.graph.Graph;
import ds.graph.UndirectedGraph;
import ds.graph.Vertex;

import java.util.*;

/**
 * Created by sherxon on 3/21/17.
 */
public class PolynomialSolutionForVertexCover {
    public static void main(String[] args) {

        int ran = (int) (Math.random() * 100);
        System.out.println("number of graphs" + ran);
        for (int i = 0; i < ran; i++) {
            Graph<Integer> graph = new UndirectedGraph<>();
            Graph<Integer> graphForBrute = new UndirectedGraph<>();
            int randomVertexNum = (int) (Math.random() * 100);
            System.out.println("number of vertices" + randomVertexNum);
            for (int j = 0; j < randomVertexNum; j++) {
                graph.addVertex(j);
                graphForBrute.addVertex(j);
            }

            int numOfEdge = (int) (Math.random() * randomVertexNum);
            System.out.println("number of edges" + numOfEdge);
            for (int j = 0; j < numOfEdge; j++) {
                int from = (int) (Math.random() * 100);
                int to = (int) (Math.random() * 100);
                graph.addEdge(from, to);
                graphForBrute.addEdge(from, to);
            }
            Set<Vertex<Integer>> mySolution = getSolution(graph);
            Set<Vertex<Integer>> bruteSolution = getSolutionBrute(graphForBrute);
            // check solutions
            if (mySolution.size() != bruteSolution.size()) {
                System.out.println("found a bug");
                System.out.println(mySolution);
                System.out.println(bruteSolution);
            } else {
                System.out.println("Size the same!!!!------------------------");
                for (Vertex<Integer> integerVertex : mySolution) {
                    if (!bruteSolution.contains(integerVertex)) {
                        System.out.println("found a bug here");
                        System.out.println(integerVertex);
                    }
                }
            }

        }
    }

    private static Set<Vertex<Integer>> getSolutionBrute(Graph<Integer> graph) {
        Set<Vertex<Integer>> set = new HashSet<>();
        List<List<Vertex<Integer>>> powerSet = getPowerSet(graph.getVertices());
        Collections.sort(powerSet, (a, b) -> a.size() - b.size());
        for (List<Vertex<Integer>> vertexes : powerSet) {
            if (isMinVCover(vertexes, graph)) {
                return new HashSet<>(vertexes);
            }
        }
        return set;
    }

    private static List<List<Vertex<Integer>>> getPowerSet(Collection<Vertex<Integer>> vertices) {
        return null;
    }

    private static boolean isMinVCover(List<Vertex<Integer>> vertexes, Graph<Integer> graph) {
        Set<Vertex<Integer>> set = new HashSet<>(vertexes);

        return false;
    }

    private static Set<Vertex<Integer>> getSolution(Graph<Integer> graph) {
        Set<Vertex<Integer>> set = new HashSet<>();
        return set;
    }
}
