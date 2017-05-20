package problems.medium;

import java.util.*;

/**
 * Created by sherxon on 1/25/17.
 */
public class CourseScheduleII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOrder(2, new int[][]{
                {1, 0},
        })));
    }

    static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return new int[0];
        if (numCourses == 1) return new int[]{0};
        int[] a = new int[numCourses];
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new HashSet<>());
        }
        int[] inDegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            list.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }
        boolean[] total = new boolean[numCourses];
        int ii = 0;
        boolean[] visited = new boolean[numCourses];
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                boolean[] recStack = new boolean[numCourses];
                boolean hasCycle = topSort(list, recStack, visited, i, l);
                if (hasCycle) return new int[0];

                for (int j = 0; j < visited.length; j++)
                    if (visited[j]) total[j] = true;

            }
        }
        for (Integer integer : l)
            a[ii++] = integer;
        for (int i = 0; i < total.length; i++) {
            if (!total[i]) {
                if (list.get(i).size() > 0) return new int[0];
                a[ii++] = i;
            }
        }

        return a;
    }

    private static boolean topSort(List<Set<Integer>> list, boolean[] recStack, boolean[] visited, int i, List<Integer> l) {
        recStack[i] = true;
        visited[i] = true;
        for (Integer child : list.get(i)) {
            if (!visited[child] && topSort(list, recStack, visited, child, l))
                return true;
            else if (recStack[child])
                return true;
        }
        l.add(i);
        recStack[i] = false;
        return false;
    }
}
