package problems.medium;

import problems.utils.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Why Did you create this class? what does it do?
 */
public class AllNodesDistanceKinBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list = new ArrayList<>();
        if (root == null || target == null || k < 0)
            return list;
        if (k == 0) {
            list.add(target.val);
            return list;
        }
        Map<TreeNode, Set<TreeNode>> map = new HashMap<>();
        map.put(root, new HashSet<>());

        map.get(root).add(root.left);
        map.get(root).add(root.right);

        go(map, root.left, root);
        go(map, root.right, root);

        return bfs(map, target, k);
    }

    List<Integer> bfs(Map<TreeNode, Set<TreeNode>> map, TreeNode src, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(src);
        Set<TreeNode> visited = new HashSet<>();
        int count = 1;
        while (!q.isEmpty()) {
            TreeNode current = q.remove();
            count--;
            //System.out.println(current.val);
            visited.add(current);
            if (map.get(current) != null)
                for (TreeNode nei : map.get(current)) {
                    if (!visited.contains(nei)) {
                        q.add(nei);
                    }
                }
            if (count == 0) {
                k--;
                count += q.size();
            }
            if (k == 0) {
                return q.stream().filter(e -> e != null).map(e -> e.val).collect(Collectors.toList());
            }
        }
        return new ArrayList<>();
    }

    void go(Map<TreeNode, Set<TreeNode>> map, TreeNode x, TreeNode parent) {
        if (x == null)
            return;
        map.put(x, new HashSet<>());
        map.get(x).add(parent);
        if (x.left != null)
            map.get(x).add(x.left);
        if (x.right != null)
            map.get(x).add(x.right);
        go(map, x.left, x);
        go(map, x.right, x);

    }
}
