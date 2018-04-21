package amazon.tamru;

import java.util.*;

/**
 * Why Did you create this class? what does it do?
 */
public class Solution1 {
    public static void main(String[] args) {
        System.out.println(new Solution1().retrieveMostFrequentlyUsedWords(
                "jack and jill went to the market to buy bread and cheese cheese is jack",
                Arrays.asList("and", "he", "the", "to", "is")
        ));
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<String> retrieveMostFrequentlyUsedWords(String literatureText, List<String> wordsToExclude) {
        // WRITE YOUR CODE HERE
        if (literatureText == null || literatureText.isEmpty())
            return new ArrayList<>();
        Set<String> ex = new HashSet<>(wordsToExclude);
        String[] a = literatureText.split(" ");
        Map<String, Integer> map = new HashMap<>();

        Arrays.stream(a)
                .filter(s -> !ex.contains(s))
                .forEach(s -> map.put(s, map.getOrDefault(s, 0) + 1));

        Set<String> res = new HashSet<>();
        int max = 0;
        for (String s : map.keySet()) {
            if (map.get(s) > max) {
                res.clear();
                res.add(s);
                max = map.get(s);
            } else if (max == map.get(s)) {
                res.add(s);
            }
        }

        return new ArrayList<>(res);
    }
    // METHOD SIGNATURE ENDS
}
