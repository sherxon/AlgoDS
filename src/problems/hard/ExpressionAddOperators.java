package problems.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sherxon on 1/16/17.
 */
// not solved;
public class ExpressionAddOperators {
    public static void main(String[] args) {
        System.out.println(addOperators("105", 5));
    }

    static List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<>();
        if (num.length() == 0) return list;
        rec(num, "", target, list);
        return list;
    }

    private static void rec(String num, String exp, int target, List<String> list) {

        if (num.length() == 1) {
            if (Integer.parseInt(num) == target) {
                list.add(num + exp);
            }
            return;
        }
        String f = num.substring(0, num.length() - 1);
        String s = num.substring(num.length() - 1);
        int i = Integer.parseInt(s);
        if (i != 0 && target % i == 0)
            rec(f, "*" + s + exp, target / i, list);
        rec(f, "+" + s + exp, target - i, list);
        rec(f, "-" + s + exp, target + i, list);

    }
}
