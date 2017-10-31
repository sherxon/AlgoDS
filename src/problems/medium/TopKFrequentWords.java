package problems.medium;

import java.util.*;

/**
 * Why Did you create this class? what does it do?
 */
public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> {
            int c = b.getValue() - a.getValue();
            if (c == 0)
                return a.getKey().compareTo(b.getKey());
            return c;
        });
        queue.addAll(map.entrySet());
        List<String> list = new ArrayList<>();
        while (k > 0) {
            list.add(queue.poll().getKey());
            k--;
        }
        return list;
    }

}
