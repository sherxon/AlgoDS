package problems.medium;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Why Did you create this class? what does it do?
 */
public class FindEventualSafeStates {
    public static void main(String[] args) {
        System.out.println(new FindEventualSafeStates().eventualSafeNodes(new int[][] {
                { 1, 2 },
                { 2, 3 },
                { 5 },
                { 0 },
                { 5 },
                {},
                {},
                }));
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        if (graph == null || graph.length == 0)
            return new ArrayList<>();
        int[] cycles = new int[graph.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (!checkCycle(i, graph, cycles)) {
                list.add(i);
            }
        }
        return list;
    }

    private boolean checkCycle(int node, int[][] graph, int[] stack) {
        if (stack[node] > 0)
            return stack[node] == 2;
        stack[node] = 2;
        int[] edges = graph[node];
        for (int i = 0; i < edges.length; i++) {
            if (stack[edges[i]] == 2 || checkCycle(edges[i], graph, stack)) {
                return true;
            }
        }
        stack[node] = 1;
        return false;
    }
}
