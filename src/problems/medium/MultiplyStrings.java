package problems.medium;

/**
 * Why Did you create this class? what does it do?
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().multiply(
                "9133",
                "0"
        ));
    }

    public String multiply(String a, String b) {
        if (a == null || b == null)
            return a;
        if (a.length() == 0) {
            return b;
        } else if (b.length() == 0) {
            return a;
        }
        int k = 0;
        while (k < a.length()) {
            if (a.charAt(k) != '0')
                break;
            k++;
        }
        a = a.substring(k, a.length());
        k = 0;
        while (k < a.length()) {
            if (a.charAt(k) != '0')
                break;
            k++;
        }

        b = b.substring(k, b.length());

        if (a.length() == 0 || b.length() == 0 || a.equals("0") || b.equals("0"))
            return "0";

        StringBuilder min = new StringBuilder(a.length() <= b.length() ? a : b);
        StringBuilder max = new StringBuilder(a.length() > b.length() ? a : b);

        StringBuilder res = new StringBuilder();
        for (int i = min.length() - 1; i >= 0; i--) {
            StringBuilder sb = go(max, (int) (min.charAt(i) - '0'));
            if (res.length() == 0) {
                res = sb;
            } else {
                sb.append(zeros(min.length() - 1 - i));
                res = add(res, sb);
            }
        }
        return res.toString();
    }

    private String zeros(int i) {
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < i; j++) {
            builder.append(0);
        }
        return builder.toString();
    }

    StringBuilder add(StringBuilder a, StringBuilder b) {
        int ii = a.length() - 1;
        int jj = b.length() - 1;
        StringBuilder nr = new StringBuilder();
        int q = 0;
        while (ii >= 0 || jj >= 0) {
            int sum = q;
            if (ii >= 0 && jj >= 0) {
                sum += (a.charAt(ii) - '0') + (b.charAt(jj) - '0');
            } else if (ii >= 0) {
                sum += (a.charAt(ii) - '0');
            } else {
                sum += (b.charAt(jj) - '0');
            }
            nr.append(sum % 10);
            q = sum / 10;

            ii--;
            jj--;
        }
        if (q != 0)
            nr.append(q);
        return nr.reverse();
    }

    StringBuilder go(StringBuilder s, int n) {
        StringBuilder sb = new StringBuilder();
        int q = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int m = ((int) (s.charAt(i) - '0')) * n + q;
            sb.append(m % 10);
            q = m / 10;
        }
        if (q != 0)
            sb.append(q);
        return sb.reverse();
    }
}
