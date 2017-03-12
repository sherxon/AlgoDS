package contests;

/**
 * Created by sherxon on 3/11/17.
 */
public class ReverseString {
    public static void main(String[] args) {
        System.out.println(new ReverseString().reverseStr("abcdefghij", 3));
    }

    public String reverseStr(String s, int k) {
        if (s.length() == 0) return s;
        if (s.length() <= k) return new StringBuilder(s).reverse().toString();

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i <= s.length() - k * 2) {
            sb.append(new StringBuilder(s.substring(i, i + k)).reverse());
            sb.append(s.substring(i + k, i + 2 * k));
            i += (2 * k);
        }
        if (i < s.length() && i + k > s.length()) {
            sb.append(new StringBuilder(s.substring(i, s.length())).reverse());
        } else if (i + k <= s.length()) {
            sb.append(new StringBuilder(s.substring(i, i + k)).reverse());
            sb.append(s.substring(i + k, s.length()));
        }

        return sb.toString();
    }
}
