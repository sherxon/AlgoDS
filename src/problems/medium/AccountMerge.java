package problems.medium;

import java.util.*;

/**
 * Why Did you create this class? what does it do?
 */
public class AccountMerge {
    public static void main(String[] args) {
        List<List<String>> lists = new ArrayList<>();
        lists.add(new ArrayList<String>() {{
            add("David");
            add("David0@m.co");
            add("David1@m.co");
        }});
        lists.add(new ArrayList<String>() {{
            add("David");
            add("David3@m.co");
            add("David4@m.co");
        }});
        lists.add(new ArrayList<String>() {{
            add("David");
            add("David4@m.co");
            add("David5@m.co");
        }});
        lists.add(new ArrayList<String>() {{
            add("David");
            add("David2@m.co");
            add("David3@m.co");
        }});
        lists.add(new ArrayList<String>() {{
            add("David");
            add("David1@m.co");
            add("David2@m.co");
        }});
        System.out.println(new AccountMerge().accountsMerge(lists));
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts == null || accounts.size() <= 1)
            return accounts;
        List<List<String>> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int j = 0; j < accounts.size(); j++) {
            List<String> e = accounts.get(j);
            boolean yes = false;
            int count = 0;
            for (int i = 1; i < e.size(); i++) {
                if (map.containsKey(e.get(i))) {
                    yes = true;
                    count = map.get(e.get(i));
                    break;
                }
            }
            for (int i = 1; i < e.size(); i++) {
                if (yes) {
                    map.put(e.get(i), count);
                } else {
                    map.put(e.get(i), j);
                }
            }
        }
        Map<Integer, Set<String>> m = new HashMap<>();
        for (String key : map.keySet()) {
            if (!m.containsKey(map.get(key))) {
                m.put(map.get(key), new HashSet<>());
            }
            m.get(map.get(key)).add(key);
        }
        for (Integer key : m.keySet()) {
            List<String> ll = new ArrayList<>(m.get(key));
            ll.add(accounts.get(key).get(0));
            ll.sort((a, b) -> {
                if (!a.contains("@"))
                    return -1;
                if (!b.contains("@"))
                    return 1;
                return a.compareTo(b);
            });
            list.add(ll);
        }
        return list;

    }
}
