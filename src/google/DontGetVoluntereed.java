package google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

/**
 * Created by sherxon on 6/17/17.
 */
public class DontGetVoluntereed {

  public static void main(String[] args) {
    Random random = new Random();
    for (int i = 0; i < 63; i++) {
      System.out.println(answer(i, random.nextInt(63)));
    }

  }

  public static int answer(int src, int dest) {
    if (src < 0 || src > 63 || dest < 0 || dest > 63) {
      return 0;
    }

    int counter = 0;
    int[][] a = new int[8][8];
    Map<Integer, Set<Integer>> map = new HashMap<>(128);
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a.length; j++) {
        a[i][j] = counter++;
      }
    }
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a.length; j++) {
        Set<Integer> set = new HashSet<>();
        map.put(a[i][j], set);
        setNeighBors(a, set, i, j);
      }
    }
    return bfs(map, src, dest);
  }

  private static int bfs(Map<Integer, Set<Integer>> map, int src, int dest) {
    if (!map.containsKey(src) || !map.containsKey(dest)) {
      return 0;
    }
    Queue<Integer> q = new LinkedList<>();
    q.add(src);
    Set<Integer> visited = new HashSet<>();
    visited.add(src);
    Map<Integer, Integer> steps = new HashMap<>();
    steps.put(src, 0);
    while (!q.isEmpty()) {
      Integer node = q.remove();
      if (!map.containsKey(node)) {
        System.out.println(node);
      }
      for (Integer nei : map.get(node)) {
        if (!visited.contains(nei)) {
          visited.add(nei);
          steps.put(nei, steps.get(node) + 1);
          q.add(nei);
          if (nei == dest) {
            return steps.get(node) + 1;
          }
        }
      }
    }
    return steps.get(dest) == null ? 0 : steps.get(dest);
  }

  private static void setNeighBors(int[][] a, Set<Integer> set, int i, int j) {
    if (i == 0 && j == 5) {
      System.out.println(i);
    }
    if (i + 2 < 8 && j + 1 < 8) {
      set.add((i + 2) * 8 + j + 1);
    }
    if (i + 2 < 8 && j - 1 >= 0) {
      set.add((i + 2) * 8 + j - 1);
    }
    if (i - 2 >= 0 && j + 1 < 8) {
      set.add((i - 2) * 8 + j + 1);
    }
    if (i - 2 >= 0 && j - 1 >= 0) {
      set.add((i - 2) * 8 + j - 1);
    }
    if (i + 1 < 8 && j - 2 >= 0) {
      set.add((i + 1) * 8 + j - 2);
    }
    if (i - 1 >= 0 && j - 2 >= 0) {
      set.add((i - 1) * 8 + j - 2);
    }
    if (i - 1 >= 0 && j + 2 < 8) {
      set.add((i - 1) * 8 + j + 2);
    }
    if (i + 1 < 8 && j + 2 < 8) {
      set.add((i + 1) * 8 + j + 2);
    }

  }

}
