package problems.medium;

/**
 * Created by sherxon on 1/11/17.
 */
public class Pow {
    static double myPow(double x, int n) {
        double temp = x;
        if (n == 0) return 1;
        temp = myPow(x, n / 2);
        if (n % 2 == 0) return temp * temp;
        else {
            if (n > 0) return temp * temp * x;
            else return (temp * temp) / x;
        }
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.00000, -2147483648));
    }
}
