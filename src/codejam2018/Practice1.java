package codejam2018;

import java.util.Scanner;

/**
 * Why Did you create this class? what does it do?
 */
public class Practice1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            long a = in.nextLong();
            long b = in.nextLong();
            long n = in.nextLong();
            while (a <= b) {
                long mid = a + (b - a) / 2;
                System.out.println(mid);
                String answer = in.next();
                if ("TOO_SMALL".equals(answer))
                    a = mid + 1;
                else if ("TOO_BIG".equals(answer))
                    b = mid - 1;
                else if ("CORRECT".equals(answer) || "WRONG_ANSWER".equals(answer))
                    break;
            }
        }
    }
}
