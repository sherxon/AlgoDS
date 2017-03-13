package interviewquestions.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by sherxon on 3/11/17.
 */
public class MinimumTimeDifference {
    public static void main(String[] args) {
        System.out.println(findMinDifference(Arrays.asList("23:00", "13:00")));
    }

    static public int findMinDifference(List<String> timePoints) {
        int min = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>(timePoints.size() * 2);
        for (int i = 0; i < timePoints.size(); i++) {
            String[] ss = timePoints.get(i).split(":");
            int time = Integer.parseInt(ss[0]) * 60 + Integer.parseInt(ss[1]);
            list.add(time);
            list.add(time + 24 * 60);
        }
        Collections.sort(list);
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }
        return min;
    }

}
