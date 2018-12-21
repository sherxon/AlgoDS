package adventofcode;

import java.util.*;

/**
 * Why Did you create this class? what does it do?
 */
@SuppressWarnings("Duplicates")
public class RecursiveCircus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            try {
                String s = scanner.nextLine();
                if (s.equals("1"))
                    break;
                list.add(s);
            } catch (Exception e) {
                break;
            }
        }
        System.out.println(solve2(list));
    }

    private static String solve(List<String> list) {
        if (list == null || list.isEmpty())
            return "";

        Map<String, String> map = new HashMap<>();
        String ss = "";
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            String[] a = s.split(" ");
            ss = a[0];
            if (a.length > 3) {
                for (int j = 3; j < a.length; j++) {
                    if (a[j].endsWith(","))
                        map.put(a[j].substring(0, a[j].length() - 1), a[0]);
                    else
                        map.put(a[j], a[0]);

                }
            }
        }

        while (map.get(ss) != null) {
            ss = map.get(ss);
        }
        return ss;
    }

    private static Integer solve2(List<String> list) {
        if (list == null || list.isEmpty())
            return 0;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            String[] a = s.split(" ");
            map.put(a[0], Integer.parseInt(a[1].substring(1, a[1].length() - 1)));
        }

        Map<String, Set<String>> tree = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            String[] a = s.split(" ");
            if (!tree.containsKey(a[0]))
                tree.put(a[0], new HashSet<>());
            for (int j = 3; j < a.length; j++) {
                String child = a[j];
                if (child.endsWith(","))
                    child = a[j].substring(0, a[j].length() - 1);
                tree.get(a[0]).add(child);
            }
        }
        String root = solve(list);
        go(tree, root, map);
        return res;
    }

    static int res = -1;

    private static int go(Map<String, Set<String>> map, String root, Map<String, Integer> values) {
        if (!map.containsKey(root))
            return 0;
        if (map.get(root).size() == 0)
            return values.get(root);
        int sum = values.get(root);
        Map<Integer, Integer> counts = new HashMap<>();
        Map<Integer, String> kk = new HashMap<>();
        for (String s : map.get(root)) {
            int r = go(map, s, values);
            kk.put(r, s);
            counts.put(r, counts.getOrDefault(r, 0) + 1);
            sum += r;
        }
        if (counts.size() == 1)
            return sum;
        int one = 1;
        int more = 1;
        for (Integer key : counts.keySet()) {
            if (counts.get(key) == 1) {
                one = key;
            } else {
                more = key;
            }
        }
        if (res == -1)
            res = values.get(kk.get(one)) - (one - more);
        return sum;
    }
}
