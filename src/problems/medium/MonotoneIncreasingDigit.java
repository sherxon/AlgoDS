package problems.medium;

import java.util.Stack;

/**
 * Why Did you create this class? what does it do?
 */
public class MonotoneIncreasingDigit {
    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(865832));
    }

    static public int monotoneIncreasingDigits(int n) {
        Stack<Integer> st = new Stack<>();
        while (n != 0) {
            int r = n % 10;
            if (st.isEmpty()) {
                st.add(r);
            } else {
                if (r > st.peek()) {
                    int counter = 0;
                    while (!st.isEmpty() && st.peek() <= 9) {
                        counter++;
                    }
                    for (int i = 0; i < counter; i++) {
                        st.add(9);
                    }

                    st.add(r - 1);
                } else if (r == 0) {
                    st.pop();
                    st.add(9);
                    st.add(0);
                } else {
                    st.add(r);
                }
            }
            n /= 10;
        }
        int res = 0;
        while (!st.isEmpty()) {
            res *= 10;
            res += st.pop();

        }
        return res;

    }
}
