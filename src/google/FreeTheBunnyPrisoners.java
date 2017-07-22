package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sherxon on 7/10/17.
 */
public class FreeTheBunnyPrisoners {
    public static void main(String[] args) {
        int[][] a = answer(4, 4);
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }

    public static int[][] answer(int num_buns, int num_required) {
        int[] a = new int[num_buns];
        boolean[] b = new boolean[num_buns];

        List<List<Integer>> list = new ArrayList<>();

        go(b, num_required, list, 0, 0);

        int total = list.size() * num_required;

        int rt = num_buns - num_required + 1;

        b = new boolean[num_buns];
        List<List<Integer>> list2 = new ArrayList<>();

        go(b, rt, list2, 0, 0);

        int[][] result = new int[num_buns][];
        List<List<Integer>> r = new ArrayList<>();
        for (int i = 0; i < num_buns; i++) {
            r.add(new ArrayList<>());
        }
        for (int i = 0; i < total / rt; i++) {
            List<Integer> t = list2.get(i);
            for (int integer : t) {
                r.get(integer).add(i);
            }
        }
        for (int i = 0; i < r.size(); i++) {
            if (result[i] == null) {
                result[i] = new int[r.get(i).size()];
            }
            for (int j = 0; j < r.get(i).size(); j++) {
                result[i][j] = r.get(i).get(j);
            }
        }
        return result;
    }

    private static void go(boolean[] b, int num_required, List<List<Integer>> list, int i, int k) {
        if (i > b.length) return;
        if (i == b.length && k >= num_required) {
            List<Integer> l = new ArrayList<>(num_required);
            for (int j = 0; j < b.length; j++) {
                if (b[j]) l.add(j);
            }
            list.add(l);
        } else {
            for (int j = i; j < b.length; j++) {
                if (!b[j] && k < num_required) {
                    b[j] = true;
                    go(b, num_required, list, j + 1, k + 1);
                    b[j] = false;
                } else if (k == num_required) {
                    go(b, num_required, list, j + 1, k + 1);
                }

            }
        }
    }


}
