package interviewquestions.easy;

/**
 * Created by sherxon on 3/25/17.
 */
public class PerfectNumber {
    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(1));
    }

    static public boolean checkPerfectNumber(int num) {
        if (num % 2 != 0) return false;

        long n = 0;
        int i = 1;
        while (n < num) {
            n = (long) (Math.pow(2, i) * (Math.pow(2, i + 1) - 1));
            i++;
        }
        return n == num;
    }
}
