package interviewquestions.easy;

/**
 * Created by sherxon on 1/29/17.
 */
public class ReverseVowels {
    public static void main(String[] args) {
        System.out.println(gcd(12, 18));
    }

    static int gcd(int m, int n) {
        if (n % m == 0) return m;
        if (m % n == 0) return n;
        if (m > n)
            return gcd(m % n, m);
        else
            return gcd(n % m, n);
    }

    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;
        String v = "euioaEUIOA";
        char[] a = s.toCharArray();
        while (i < j) {
            while (i < j && v.indexOf(a[i]) == -1) i++;
            while (i < j && v.indexOf(a[j]) == -1) j--;
            if (i < j) {
                char temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        return new String(a);
    }

}
