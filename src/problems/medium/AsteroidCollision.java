package problems.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * Why Did you create this class? what does it do?
 */
public class AsteroidCollision {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[] {
                -2, -1, 1, 2
        })));
        System.out.println(Arrays.toString(asteroidCollision(new int[] {
                5, 10, -5
        })));
        System.out.println(Arrays.toString(asteroidCollision(new int[] {
                8, -8
        })));
        System.out.println(Arrays.toString(asteroidCollision(new int[] {
                10, 2, -5
        })));
        System.out.println(Arrays.toString(asteroidCollision(new int[] {
                10, 2, -5, -14
        })));
    }

    static public int[] asteroidCollision(int[] a) {
        if (a == null || a.length == 0)
            return a;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            st.push(a[a.length - 1 - i]);
        }
        Stack<Integer> st2 = new Stack<>();
        while (!st.isEmpty()) {
            int pop = st.pop();
            if (st2.isEmpty()) {
                st2.add(pop);
                continue;
            }
            if ((pop < 0 && st2.peek() > 0)) {
                int pop2 = st2.pop();
                if (Math.abs(pop2) > Math.abs(pop)) {
                    st2.add(pop2);
                } else if (Math.abs(pop2) < Math.abs(pop)) {
                    st.add(pop);
                }
            } else {
                st2.add(pop);
            }
        }
        int[] res = new int[st2.size()];
        int k = 0;
        while (!st2.isEmpty()) {
            res[res.length - 1 - k] = st2.pop();
            k++;
        }
        return res;
    }
}
