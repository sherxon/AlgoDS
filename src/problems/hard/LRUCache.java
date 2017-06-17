package problems.hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by sherxon on 6/17/17.
 */
class ListNode {

  public int key;
  public int val;

  public ListNode(int key, int val) {
    this.val = val;
    this.key = key;
  }

  public boolean equals(Object o) {
    ListNode ob = (ListNode) o;
    return this.key == ob.key;
  }
}

public class LRUCache {

  LinkedList<ListNode> list = new LinkedList<>();

  Map<Integer, ListNode> map = new HashMap<>();

  int n = 0;

  public LRUCache(int capacity) {
    this.n = capacity;
  }

  public int get(int key) {
    ListNode node = map.get(key);
    if (node == null) {
      return -1;
    }
    list.remove(node);
    list.add(node);
    return node.val;
  }

  public void put(int key, int value) {
    ListNode node = new ListNode(key, value);

    if (map.containsKey(key)) {
      list.remove(node);
    }
    list.add(node);

    if (list.size() > n) {
      ListNode old = list.removeFirst();
      map.remove(old.key);
    }
    map.put(key, node);

  }
}