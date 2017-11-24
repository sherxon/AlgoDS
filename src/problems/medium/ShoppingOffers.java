package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Why Did you create this class? what does it do?
 */
public class ShoppingOffers {

    public static void main(String[] args) {
        List<Integer> price = Arrays.asList(2, 3, 4);
        List<Integer> needs = Arrays.asList(1, 2, 1);
        List<List<Integer>> offers = new ArrayList<>();
        offers.add(Arrays.asList(1, 1, 0, 4));
        offers.add(Arrays.asList(2, 2, 1, 9));
        System.out.println(shoppingOffers(price, offers, needs));
    }

    static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (needs.size() == 0)
            return 0;
        int sumNeed = 0;
        int totalMin = 0;
        for (int i = 0; i < needs.size(); i++) {
            sumNeed += needs.get(i);
            totalMin += price.get(i) * needs.get(i);
        }
        if (sumNeed == 0)
            return 0;

        for (List<Integer> list : special) {
            List<Integer> afterOffer = new ArrayList<>();
            boolean valid = true;
            for (int i = 0; i < needs.size(); i++) {
                if (list.get(i) > needs.get(i)) {
                    valid = false;
                    break;
                }
                afterOffer.add(needs.get(i) - list.get(i));
            }
            if (!valid)
                continue;
            int took = shoppingOffers(price, special, afterOffer) + list.get(list.size() - 1);
            totalMin = Math.min(took, totalMin);
        }
        return totalMin;
    }
}
