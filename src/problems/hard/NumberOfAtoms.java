package problems.hard;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Why Did you create this class? what does it do?
 */
public class NumberOfAtoms {

    //    public static void main(String[] args) {
    //        System.out.println(countOfAtoms("K4(ON(SO3)2)2"));
    //    }

    // 2(2(3OS)NO)4K
    static public String countOfAtoms(String formula) {
        if (formula == null || formula.length() == 0)
            return "";
        StringBuilder builder = new StringBuilder(formula).reverse();
        Map<String, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        String elem = "";
        int sum = 1;
        for (int i = 0; i < builder.length(); i++) {
            char c = builder.charAt(i);
            if (Character.isDigit(c)) {
                int j = i;
                while (j < builder.length() && Character.isDigit(builder.charAt(j)))
                    j++;
                if (j != i) {
                    stack.add(Integer.parseInt(builder.substring(i, j)));
                    sum *= stack.peek();
                    j = i = 1;
                }
            } else if (c == '(') {

            }

        }
        return map.keySet().stream().sorted().map(s -> s + map.get(s)).collect(Collectors.joining());
    }

    private static int getNextDigit(StringBuilder builder, int i) {

        return 1;
    }

    //    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
    //        if (price.size() == 0 || needs.size() == 0)
    //            return 0;
    //        int actual = 0;
    //        for (int i = 0; i < needs.size(); i++) {
    //            actual += needs.get(i) * price.get(i);
    //        }
    //        int mini = -1;
    //        int result = 0;
    //        for (int i = 0; i < special.size(); i++) {
    //            List<Integer> offer = special.get(i);
    //            int offerCost = 0;
    //            int actualCost = 0;
    //            for (int j = 0; j < needs.size(); j++) {
    //                if (offer.get(i) > needs.get(i)) {
    //                    offerCost = 0;
    //                    break;
    //                }
    //                offerCost += offer.get(i) * needs.get(i);
    //                actualCost += price.get(i) * needs.get(i);
    //            }
    //
    //        }
    //        return result;
    //    }



}
