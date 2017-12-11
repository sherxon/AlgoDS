package adventofcode;

import java.util.Arrays;
import java.util.List;

/**
 * Why Did you create this class? what does it do?
 */
@SuppressWarnings("Duplicates") public class KnotHash_10 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(227, 169, 3, 166, 246, 201, 0, 47, 1, 255, 2, 254, 96, 3, 97, 144);
        System.out.println(solve(list));
    }

    private static int solve(List<Integer> list) {
        if (list == null || list.isEmpty())
            return 0;
        int[] a = new int[256];
        for (int i = 0; i < a.length; i++)
            a[i] = i;

        int skipSize = 0;
        int current = 0;
        for (int i = 0; i < list.size(); i++) {
            int length = list.get(i);
            int[] reversed = reverse(a, current, length);
            int k = current;
            for (int j = 0; j < reversed.length; j++) {
                a[k % a.length] = reversed[j];
                k++;
            }
            current += skipSize + length;
            skipSize++;
        }
        return a[0] * a[1];
    }

    private static int[] reverse(int[] a, int current, int length) {
        int[] rev = new int[length];
        int k = 0;
        for (int i = current; i < current + length; i++) {
            rev[k++] = a[i % a.length];
        }
        int i = 0;
        int j = rev.length - 1;
        while (i < j) {
            int temp = rev[i];
            rev[i] = rev[j];
            rev[j] = temp;
            i++;
            j--;
        }
        return rev;
    }
}
