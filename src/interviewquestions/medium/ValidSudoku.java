package interviewquestions.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by sherxon on 2/9/17.
 */
public class ValidSudoku {
    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] a) {
        if (a.length == 0 || a[0].length == 0) return false;
        Map<Integer, Set<Integer>> cols = new HashMap<>();
        Map<Integer, Set<Integer>> rows = new HashMap<>();
        Map<Integer, Set<Integer>> cell = new HashMap<>();
        for (int i = 0; i < a[0].length; i++) {
            cols.put(i, new HashSet<>());
            cell.put(i, new HashSet<>());
        }
        for (int i = 0; i < a.length; i++) {
            rows.put(i, new HashSet<>());
            for (int j = 0; j < a[i].length; j++) {
                if (Character.isDigit(a[i][j])) {
                    if (!rows.get(i).add(a[i][j] - '0')) return false;
                    if (!cols.get(j).add(a[i][j] - '0')) return false;
                    int index = (j == 0 ? 0 : j / 3) + (i == 0 ? 0 : i / 3);
                    if (i <= 5 && i > 2) index += 2;
                    if (i <= 8 && i > 5) index += 4;
                    System.out.println(index + " " + i + " " + j);
                    if (!cell.get(index).add(a[i][j] - '0')) return false;
                }
            }
        }
        return true;
    }
}
