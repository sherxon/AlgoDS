package contests.contest27;

/**
 * Created by sherxon on 4/8/17.
 */
public class ReverseWordsinString3 {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    static public String reverseWords(String s) {
        if (s == null || s.trim().length() == 0) return s;
        char[] a = s.toCharArray();
        reverse(a, 0, s.length() - 1);
        String res = new String(a);
        String[] b = res.split(" ");
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = b.length - 1; i >= 0; i--) {
            sb.append(b[i]);
            if (i != 0) sb.append(" ");
        }
        return sb.toString();
    }

    static private void reverse(char[] a, int i, int j) {
        while (i < j) {
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }

    }


}
