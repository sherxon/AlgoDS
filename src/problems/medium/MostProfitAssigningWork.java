package problems.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Why Did you create this class? what does it do?
 */
public class MostProfitAssigningWork {
    public static void main(String[] args) {
        System.out.println(maxProfitAssignment(new int[] {
                        2, 4, 6, 8, 10
                },
                new int[] {
                        10, 20, 30, 40, 50
                },
                new int[] {
                        1
                }
        ));
    }

    static public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        if (difficulty == null || difficulty.length == 0)
            return 0;
        if (worker == null || worker.length == 0)
            return 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int minDifficulty = Integer.MAX_VALUE;
        for (int i = 0; i < profit.length; i++) {
            map.put(difficulty[i], Math.max(profit[i], map.getOrDefault(difficulty[i], 0)));
            minDifficulty = Math.min(difficulty[i], minDifficulty);
        }
        Map<Integer, Integer> dp = new HashMap<>();
        int max = 0;
        for (Integer key : map.keySet()) {
            max = Math.max(max, map.get(key));
            dp.put(key, max);
        }
        int sum = 0;
        for (int i = 0; i < worker.length; i++) {
            if (worker[i] < minDifficulty)
                continue;
            sum += dp.get(map.floorKey(worker[i]));
        }
        return sum;
    }
}
