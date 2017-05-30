package problems.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sherxon on 5/20/17.
 */
public class FileSystem {

  Node root;

  public FileSystem() {
    root = new Node("");
  }

  public List<String> ls(String path) {
    List<String> list = new ArrayList<>();
    ls(path.split("/"), 0, list, root);
    return list;
  }

  private void ls(String[] path, int i, List<String> list, Node root) {
    if (root == null) {
      return;
    }
    if (i == path.length - 1) {
      list.addAll(root.children.keySet());
      return;
    }

    ls(path, i + 1, list, root.children.get(path[i + 1]));
  }

  public void mkdir(String path) {
    mkdir(path.split("/"), root, 1);
  }

  private void mkdir(String[] split, Node root, int i) {
    if (i == split.length - 1) {
      return;
    }
    if (!root.children.containsKey(split[i])) {
      root.children.put(split[i], new Node(split[i]));
    }
    mkdir(split, root.children.get(split[i]), i + 1);
  }

  public void addContentToFile(String filePath, String content) {

  }


  private class Node {

    String name;
    Map<String, Node> children = new HashMap<>();
    String content;

    public Node(String n) {
      this.name = n;
    }
  }

}
