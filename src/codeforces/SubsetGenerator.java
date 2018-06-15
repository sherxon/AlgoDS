package codeforces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Why Did you create this class? what does it do?
 */
public class SubsetGenerator {
    public static void main(String[] args) {
        System.out.println(subSets(3));
        permutations(new int[] { 1, 2, 3 }, 0);
    }

    private static List<List<Integer>> subSets(int n) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] a = new boolean[n];
        go(a, 0, list);
        return list;
    }

    private static void go(boolean[] a, int i, List<List<Integer>> list) {
        if (i > a.length)
            return;

        if (i == a.length) {
            List<Integer> ll = new ArrayList<>();
            for (int j = 0; j < a.length; j++) {
                if (a[j])
                    ll.add(j + 1);
            }
            list.add(ll);
            return;
        }

        a[i] = true;
        go(a, i + 1, list);
        a[i] = false;
        go(a, i + 1, list);
    }

    private static void permutations(int[] a, int i) {
        if (i > a.length)
            return;
        if (i == a.length) {
            System.out.println(Arrays.toString(a));
            return;
        }

        for (int j = i; j < a.length; j++) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            permutations(a, i + 1);
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
}

