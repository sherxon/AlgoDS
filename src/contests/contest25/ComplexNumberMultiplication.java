package contests.contest25;

/**
 * Created by sherxon on 3/25/17.
 */
public class ComplexNumberMultiplication {
    public static void main(String[] args) {

    }

    public String complexNumberMultiply(String a, String b) {
        String s = "";
        String a1 = a.split("\\+")[0];
        String a2 = a.split("\\+")[1];
        String b1 = b.split("\\+")[0];
        String b2 = b.split("\\+")[1];
        long res = 0;
        if (a2.contains("\\-")) {
            int right = Integer.parseInt(b2.substring(0, b2.length() - 1));
            res = Integer.parseInt(a1) * Integer.parseInt(b1) + right * right;

        } else {

        }
        return s;
    }
}
