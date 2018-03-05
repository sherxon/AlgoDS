package problems.easy;

/**
 * Why Did you create this class? what does it do?
 */
public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0)
            return 0;

        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }
}
