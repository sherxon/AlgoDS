package problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by sherxon on 6/3/17.
 */
public class FindDuplicateFileinSystem {

  public List<List<String>> findDuplicate(String[] a) {
    List<List<String>> list = new ArrayList<>();
    if (a.length == 0) {
      return list;
    }
    Map<String, Set<String>> map = new HashMap<>();
    for (String s : a) {
      char[] c = s.toCharArray();
      int ii = -1, jj = -1, ij = -1;
      for (int i = 0; i < c.length; i++) {
        if (c[i] == ' ') {
          ij = i;
        } else if (c[i] == '(') {
          ii = i;
        } else if (c[i] == ')') {
          jj = i;
          String content = s.substring(ii, jj + 1);
          String path = s.substring(0, s.split(" ")[0].length());
          String filename = s.substring(ij + 1, ii);

          if (!map.containsKey(content)) {
            map.put(content, new HashSet<>());
          }
          map.get(content).add(path + "/" + filename);
          ii = -1;
          jj = -1;
        }
      }
    }

    for (String s : map.keySet()) {
      if (map.get(s).size() > 1) {
        List<String> l = new ArrayList<>(map.get(s));
        list.add(l);
      }
    }
    return list;

  }

}
