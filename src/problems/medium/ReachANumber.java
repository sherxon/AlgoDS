package problems.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Why Did you create this class? what does it do?
 */
public class ReachANumber {
    public static void main(String[] args) {
        System.out.println(reachNumber(2));
        System.out.println(reachNumber(8));
        System.out.println(reachNumber(11));
        System.out.println(reachNumber(50));
        System.out.println(reachNumber(-1000000000));
    }

    static public int reachNumber(int target) {
        Queue<Wrap> q = new LinkedList<>();
        Map<Wrap, Integer> d = new HashMap<>();
        Wrap wrap = new Wrap(0);
        d.put(wrap, 0);
        q.add(wrap);
        while (!q.isEmpty()) {
            Wrap cur = q.remove();
            Wrap right = new Wrap(cur.value + (d.get(cur) + 1));
            Wrap left = new Wrap(cur.value - (d.get(cur) + 1));
            if (right.value == target || left.value == target) {
                return d.get(cur) + 1;
            }

            q.add(left);
            q.add(right);
            d.put(left, d.get(cur) + 1);
            d.put(right, d.get(cur) + 1);
        }
        return d.get(target);
    }

    static class Wrap {
        int value = 0;

        public Wrap(int value) {
            this.value = value;
        }
    }
}
