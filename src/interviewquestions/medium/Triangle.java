package interviewquestions.medium;

import java.util.List;

/**
 * Created by sherxon on 2/14/17.
 */
public class Triangle {
    public static void main(String[] args) {

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) return 0;
        int min = Integer.MAX_VALUE;
        if (triangle.size() == 1) {
            for (int i = 0; i < triangle.get(0).size(); i++) {
                min = Math.min(triangle.get(0).get(i), min);
            }
        }


        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> prev = triangle.get(i - 1);
            List<Integer> current = triangle.get(i);
            for (int j = 0; j < current.size(); j++) {
                if (j == 0) {
                    current.set(j, prev.get(j) + current.get(j));
                } else if (j == current.size() - 1) {
                    current.set(j, prev.get(j - 1) + current.get(j));
                } else {
                    int minPrev = Math.min(prev.get(j), prev.get(j - 1));
                    current.set(j, minPrev + current.get(j));
                }
                if (i == triangle.size() - 1) {
                    min = Math.min(current.get(j), min);
                }
            }

        }

        return min;
    }
}
