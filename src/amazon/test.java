package amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by sherxon on 6/17/17.
 */
public class test {

  public static void main(String[] args) {

  }

  String[] largestItemAssociation(String[][] itemAssociation) {

    if (itemAssociation == null || itemAssociation.length == 0) {
      return new String[]{};
    }

    Map<String, Set<String>> map = new HashMap<>();
    Set<String> unvisited = new HashSet<>();

    for (int i = 0; i < itemAssociation.length; i++) {
      for (int j = 0; j < itemAssociation[i].length; j++) {
        if (!map.containsKey(itemAssociation[i][j])) {
          map.put(itemAssociation[i][j], new HashSet<>());
          unvisited.add(itemAssociation[i][j]);
        }
      }
    }

    for (int i = 0; i < itemAssociation.length; i++) {
      for (int j = 1; j < itemAssociation[i].length; j++) {
        map.get(itemAssociation[i][j - 1]).add(itemAssociation[i][j]);
        map.get(itemAssociation[i][j]).add(itemAssociation[i][j - 1]);
      }
    }
    List<List<String>> sets = new ArrayList<>();
    int max = 0;
    while (!unvisited.isEmpty()) {
      String start = unvisited.iterator().next();
      Set<String> island = new HashSet<>();
      dfs(start, map, unvisited, island);
      if (island.size() > max) {
        sets.clear();
        max = island.size();
      }
      if (max == island.size()) {
        sets.add(new ArrayList<>(island));
      }
    }
    if (sets.size() == 1) {
      List<String> res = sets.get(0);
      String[] resa = new String[res.size()];
      int i = 0;
      for (String re : res) {
        resa[i++] = re;
      }
      return resa;
    }
    for (List<String> set : sets) {
      Collections.sort(set);
    }
    String min = null;
    int mini = 0;
    for (int i = 0; i < sets.size(); i++) {
      if (min == null || min.compareTo(sets.get(i).get(0)) > 0) {
        min = sets.get(i).get(0);
        mini = i;
      }
    }
    List<String> rr = sets.get(mini);
    String[] last = new String[rr.size()];
    for (int i = 0; i < last.length; i++) {
      last[i] = rr.get(i);
    }
    return last;
  }

  private void dfs(String start, Map<String, Set<String>> map, Set<String> unvisited,
      Set<String> island) {
    unvisited.remove(start);
    island.add(start);

    for (String s : map.get(start)) {
      if (unvisited.contains(s)) {
        dfs(s, map, unvisited, island);
      }
    }
  }

}
