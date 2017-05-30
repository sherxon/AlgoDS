package problems.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by sherxon on 5/20/17.
 */
public class AlienAlphabet {

  static public List<Character> getABC(List<String> dict) {

    List<Character> alphabet = new ArrayList<>();

    if (dict == null || dict.size() == 0) {
      return alphabet;
    }

    Map<Character, Set<Character>> graph = new HashMap<>();

    char parent = dict.get(0).charAt(0);
    char parentCopy = dict.get(0).charAt(0);

    for (int j = 0; j < dict.size(); j++) {
      String s = dict.get(j);
      for (int i = 0; i < s.length(); i++) {

        char current = s.charAt(i);

        if (parent == current) {
          continue;
        }

        if (!graph.containsKey(parent)) {
          graph.put(parent, new HashSet<>());
        }

        graph.get(parent).add(current);
        parent = current;
      }
      parent = s.charAt(0);
    }

    topSort(graph, parentCopy, alphabet, new HashSet<>());
    Collections.reverse(alphabet);
    return alphabet;
  }

  static private void topSort(Map<Character, Set<Character>> graph, char source,
      List<Character> alphabet, HashSet<Character> visited) {

    visited.add(source);
    if (graph.containsKey(source)) {
      for (Character nei : graph.get(source)) {
        if (!visited.contains(nei)) {
          topSort(graph, nei, alphabet, visited);
        }
      }
    }
    alphabet.add(source);
  }

}
