package problems.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sherxon on 1/25/17.
 */
public class CourseSchedule {
    public static void main(String[] args) {
        System.out.println(canFinish(6, new int[][]{
                {0, 1},
                {0, 4},
                {0, 3},
                {4, 1},
                {4, 2},
                {1, 3},
                {1, 5},
                {1, 2},
                {3, 5},
                {2, 5},
                {2, 0},

        }));
    }

    static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses < 2) return true;

        List<Set<Integer>> sets = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            sets.add(new HashSet<>());

        int[] inDegrees = new int[numCourses];
        for (int[] edge : prerequisites) {
            sets.get(edge[0]).add(edge[1]);
            inDegrees[edge[1]]++;
        }
        boolean[] read = new boolean[numCourses];
        for (int head = 0; head < numCourses; head++) {
            if (inDegrees[head] == 0) {
                boolean[] recStack = new boolean[numCourses];
                boolean[] visited = new boolean[numCourses];
                boolean hasCycle = topSort(sets, head, visited, recStack);
                for (int i = 0; i < visited.length; i++) {
                    if (visited[i]) read[i] = true;
                }
                if (hasCycle) return false;
            }
        }
        for (int i = 0; i < read.length; i++) {
            if (!read[i]) return false;
        }
        return true;
    }

    private static boolean topSort(List<Set<Integer>> sets, Integer head, boolean[] visited, boolean[] recStack) {
        visited[head] = true;
        recStack[head] = true;
        for (Integer child : sets.get(head)) {
            if (!visited[child] && topSort(sets, child, visited, recStack))
                return true;
            else if (recStack[child])
                return true;
        }
        recStack[head] = false;
        return false;
    }
}
