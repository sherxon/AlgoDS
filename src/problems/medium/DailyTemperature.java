package problems.medium;

import java.util.*;

/**
 * Why Did you create this class? what does it do?
 */
public class DailyTemperature {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[] {
                73, 74, 75, 71, 69, 72, 76, 73,
                })));
    }

    static int[] dailyTemperatures(int[] a) {
        if (a == null || a.length == 0) {
            return a;
        }
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
        for (int i = 0; i < a.length; i++) {
            if (!map.containsKey(a[i]))
                map.put(a[i], new TreeSet<>());
            map.get(a[i]).add(i);
        }
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            Integer k = 0;
            Map.Entry<Integer, TreeSet<Integer>> entry = null;
            int search = a[i];
            int min = Integer.MAX_VALUE;
            while ((entry = map.higherEntry(search)) != null) {
                k = entry.getValue().higher(i);
                if (k != null && k - i > 0) {
                    min = Math.min(min, k - i);
                }
                search = entry.getKey();
            }
            res[i] = min == Integer.MAX_VALUE ? 0 : min;
        }

        return res;
    }

    static class Pair implements Comparable {
        int index;
        int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override public int compareTo(Object o) {
            Pair pair = (Pair) o;
            int d = this.value - pair.value;
            if (d != 0)
                return d;
            return this.index - pair.index;
        }

        @Override public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            Pair pair = (Pair) o;

            if (index != pair.index)
                return false;
            return value == pair.value;
        }

        @Override public int hashCode() {
            int result = index;
            result = 31 * result + value;
            return result;
        }
    }
}
