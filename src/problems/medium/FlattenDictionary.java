package problems.medium;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by sherxon on 5/21/17.
 */
public class FlattenDictionary {

  public static void main(String[] args) {
    Map<String, Object> map = new LinkedHashMap<>();
    Map<String, Object> dictionary = new LinkedHashMap<>();
    dictionary.put("key1", 1);
    dictionary.put("key2", new LinkedHashMap<>());
    ((Map) dictionary.get("key2")).put("a", 2);
    ((Map) dictionary.get("key2")).put("b", 3);
    ((Map) dictionary.get("key2")).put("c", new LinkedHashMap<>());
    ((Map) ((Map) dictionary.get("key2")).get("c")).put("d", 3);
    ((Map) ((Map) dictionary.get("key2")).get("c")).put("e", 1);
    flatten("", map, dictionary);
    for (String s : map.keySet()) {
      System.out.println(s + " " + map.get(s));
    }
  }

  private static void flatten(String s, Map<String, Object> map,
      Map<String, Object> dictionary) {

    for (String key : dictionary.keySet()) {

      if (dictionary.get(key) instanceof Map) {
        if (s.length() == 0) {
          flatten(key, map, ((Map) dictionary.get(key)));
        } else {
          flatten(s + "." + key, map, ((Map) dictionary.get(key)));
        }

      } else {
        if (s.length() == 0) {
          map.put(key, dictionary.get(key));
        } else {
          map.put(s + "." + key, dictionary.get(key));
        }
      }

    }
  }


}
