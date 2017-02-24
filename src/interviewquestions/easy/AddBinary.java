package interviewquestions.easy;

/**
 * Created by sherxon on 1/29/17.
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        boolean carry = false;
        while (i >= 0 || j >= 0) {
            boolean f = false;
            boolean s = false;
            if (i >= 0 && j >= 0) {
                f = a.charAt(i--) == '1';
                s = b.charAt(j--) == '1';
            } else if (i >= 0)
                f = a.charAt(i--) == '1';
            else
                s = b.charAt(j--) == '1';

            if (f && s) {
                sb.insert(0, carry ? 1 : 0);
                carry = true;
            } else if (f || s) {
                sb.insert(0, carry ? 0 : 1);
            } else {
                sb.insert(0, carry ? 1 : 0);
                carry = false;
            }
        }
        if (carry) sb.insert(0, 1);
        return sb.toString();


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
