package interviewquestions.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sherxon on 2/9/17.
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        spiralOrder(new int[][]{
                {1, 2, 3},
                {5, 6, 7},
                {9, 10, 11},

        });
    }

    static List<Integer> spiralOrder(int[][] a) {
        if (a.length == 0 || a[0].length == 0) return Collections.emptyList();
        int size = a.length * a[0].length;
        List<Integer> list = new ArrayList<>(size);

        for (int i = 0; i < a.length / 2 + 1; i++) {

            for (int j = i; j < a[0].length - i && list.size() < size; j++) {
                list.add(a[i][j]);
            }
            for (int j = i + 1; j < a.length - i && list.size() < size; j++) {
                list.add(a[j][a[0].length - i - 1]);
            }
            for (int j = i + 1; j < a[0].length - i && list.size() < size; j++) {
                list.add(a[a.length - i - 1][a[0].length - j - 1]);
            }
            for (int j = i + 1; j < a.length - i - 1 && list.size() < size; j++) {
                list.add(a[a.length - j - 1][i]);
            }
        }

        System.out.println(list);
        return list;
    }
}
