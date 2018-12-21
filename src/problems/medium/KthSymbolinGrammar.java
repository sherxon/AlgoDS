package problems.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Why Did you create this class? what does it do?
 */
public class KthSymbolinGrammar {

    static public int kthGrammar(int n, int k) {
        if (n == 1 && k == 1)
            return 0;
        List<Boolean> listK = new ArrayList<>();
        while (n > 1) {
            if (k > Math.pow(2, n - 2)) {
                k -= Math.pow(2, n - 2);
                listK.add(false);
            } else {
                listK.add(true);
            }
            n--;
        }
        listK.add(true);
        Collections.reverse(listK);
        boolean res = false;
        for (Boolean aBoolean : listK) {
            if (!aBoolean)
                res = !res;
        }
        return res ? 1 : 0;
    }
}
