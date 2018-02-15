package amazon;

import java.util.*;

/**
 * Why Did you create this class? what does it do?
 */
public class Amazon2 {
    public static void main(String[] args) {
        System.out.println(subSequenceTags(
                Arrays.asList("2abc", "bcd", "cab"),
                Arrays.asList("dbc", "2abc", "cab", "bcd", "bcb")
        ));
        System.out.println(subSequenceTags(
                Arrays.asList("in", "the", "spain"),
                Arrays.asList("the", "spain", "that", "the", "rain", "in", "spain", "stays", "forecast", "in", "the")
        ));
        System.out.println(subSequenceTags(
                Arrays.asList("made", "in", "spain"),
                Arrays.asList("made", "wheather", "forecast", "says", "that", "made", "rain", "in", "spain", "stays")
        ));
    }

    static List<Integer> subSequenceTags(List<String> targetList, List<String> availableTagList) {
        if (targetList == null || targetList.isEmpty() || availableTagList == null || availableTagList.isEmpty())
            return Collections.emptyList();

        Map<Integer, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>(targetList);
        int min = Integer.MAX_VALUE;
        List<Integer> res = new ArrayList<>();
        res.add(0);
        res.add(0);
        for (int i = 0; i < availableTagList.size(); i++) {
            int j = i;
            while (j < availableTagList.size()) {
                set.remove(availableTagList.get(j));
                if (set.isEmpty()) {
                    break;
                }
                j++;
            }
            if (set.isEmpty()) {
                map.put(i, j);
                if (j - i < min) {
                    min = j - i;
                    res.set(0, i);
                    res.set(1, j);
                }
                set.addAll(targetList);
            }

        }
        if (min == Integer.MAX_VALUE) {
            res = new ArrayList<>();
            res.add(0);
            return res;
        }
        return res;
    }
}
