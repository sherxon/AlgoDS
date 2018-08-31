package problems.easy;

/**
 * Why Did you create this class? what does it do?
 */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int[] a = new int[3];
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                a[0]++;
                continue;
            } else if (bills[i] == 10) {
                a[1]++;
                a[0]--;
                if (a[0] < 0)
                    return false;
            } else {
                a[2]++;
                if (a[0] < 1)
                    return false;
                a[0]--;
                if (a[1] > 0) {
                    a[1]--;
                } else {
                    a[0] -= 2;
                    if (a[0] < 0)
                        return false;
                }
            }
        }
        return true;
    }
}
