package problems.medium;

import java.util.*;

/**
 * Why Did you create this class? what does it do?
 */
public class CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        CheapestFlightsWithinKStops cheap = new CheapestFlightsWithinKStops();
        System.out.println(cheap.findCheapestPrice(6, new int[][] {
                { 0, 1, 5 }, { 1, 2, 6 }, { 0, 3, 2 }, { 3, 1, 2 }, { 1, 4, 2 }, { 4, 2, 2 }, { 0, 5, 7 }, { 5, 2, 3 },
                }, 0, 2, 3));
        System.out.println(cheap.findCheapestPrice(3, new int[][] {
                { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 }
        }, 0, 2, 0));

    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if (n <= 1)
            return 0;

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] flight : flights) {
            Map<Integer, Integer> pair = map.getOrDefault(flight[0], new HashMap<>());
            pair.put(flight[1], flight[2]);
            map.put(flight[0], pair);
        }
        Map<Integer, Map<Integer, Integer>> costs = new HashMap<>();
        costs.put(src, new HashMap<>());
        costs.get(src).put(-1, 0);

        for (int i = 0; i <= k; i++) {
            for (int current = 0; current < n; current++) {
                Map<Integer, Integer> currentCosts = costs.getOrDefault(current, new HashMap<>());
                Map<Integer, Integer> neis = map.get(current);
                if (neis == null)
                    continue;
                for (Integer step : currentCosts.keySet()) {
                    if (step >= k)
                        continue;
                    for (Integer nei : neis.keySet()) {
                        Map<Integer, Integer> neiCosts = costs.getOrDefault(nei, new HashMap<>());
                        int cost = neis.get(nei);
                        int min = Math.min(currentCosts.get(step) + cost, neiCosts.getOrDefault(step + 1, Integer.MAX_VALUE));
                        neiCosts.put(step + 1, min);
                        costs.put(nei, neiCosts);
                    }
                }
            }
        }
        Map<Integer, Integer> dstCosts = costs.getOrDefault(dst, new HashMap<>());
        if (dstCosts.isEmpty())
            return -1;
        int min = Integer.MAX_VALUE;
        for (Integer step : dstCosts.keySet()) {
            if (step <= k) {
                min = Math.min(min, dstCosts.get(step));
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

}
