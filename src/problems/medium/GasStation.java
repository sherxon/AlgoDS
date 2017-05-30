package problems.medium;

/**
 * Created by sherxon on 1/13/17.
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totgas = 0;
        int totcost = 0;
        for (int i = 0; i < gas.length; i++) {
            totgas += gas[i];
            totcost += cost[i];
        }
        if (totgas < totcost) return -1;

        for (int i = 0; i < gas.length; i++) {
            int current = 0;
            int k = i;
            for (int j = 0; j < cost.length; j++) {
                int jj = k % cost.length;
                current += gas[jj];
                current -= cost[jj];
                if (current < 0) break;
                k++;
            }
            if (current >= 0) return i;
            if (k > i) i = k;
        }

        return -1;
    }
}
