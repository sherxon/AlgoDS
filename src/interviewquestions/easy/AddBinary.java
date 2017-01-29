package interviewquestions.easy;

/**
 * Created by sherxon on 1/29/17.
 */
public class AddBinary {

    static String addBinary(String a, String b) {
        if (a.length() == 0) return b;
        if (b.length() == 0) return a;
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0) {
                if (a.charAt(i) == '1' && b.charAt(j) == '1') {
                    if (carry == 1) sb.append(1);
                    else sb.append(0);
                    carry = 1;
                } else if (a.charAt(i) == '0' && b.charAt(j) == '0') {
                    if (carry == 1) sb.append(1);
                    else sb.append("0");
                    carry = 0;
                } else {
                    if (carry == 1) sb.append("0");
                    else sb.append("1");
                }
            } else if (i >= 0) {
                if (a.charAt(i) == '1') {
                    if (carry == 1) {
                        sb.append(0);
                    } else {
                        sb.append(1);
                        carry = 0;
                    }
                } else {
                    if (carry == 1) {
                        sb.append(1);
                        carry = 0;
                    } else {
                        sb.append(0);
                    }
                }
            } else if (j >= 0) {
                if (b.charAt(j) == '1') {
                    if (carry == 1) {
                        sb.append(0);
                    } else {
                        sb.append(1);
                        carry = 0;
                    }

                } else {
                    if (carry == 1) {
                        sb.append(1);
                        carry = 0;
                    } else {
                        sb.append(0);
                    }
                }
            }
            i--;
            j--;
        }
        if (carry == 1) sb.append("1");
        return sb.reverse().toString();
    }

    public String addBinary2(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
