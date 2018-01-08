package codeforces;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Why Did you create this class? what does it do?
 */
public class Coupon {

    static List<Map<String, Object>> personalizeCoupons(List<Map<String, Object>> coupons, List<String> preferredCategories) {
        Set<String> categories = new HashSet<>(preferredCategories);
        Comparator<Map<String, Object>> comp = (a, b) -> {
            double aCoupon = Double.parseDouble(String.valueOf(a.get("couponAmount")));
            double aCost = Double.parseDouble(String.valueOf(a.get("itemPrice")));
            double bCoupon = Double.parseDouble(String.valueOf(b.get("couponAmount")));
            double bCost = Double.parseDouble(String.valueOf(b.get("itemPrice")));
            double res = bCoupon * 100 / bCost - aCoupon * 100 / aCost;
            if (res > 0)
                return 1;
            else if (res < 0)
                return -1;
            return 0;
        };
        return coupons.stream().filter(e -> categories.contains(String.valueOf(e.get("category")))).sorted(comp).limit(10).map(e -> {
            e.remove("code");
            return e;
        }).collect(Collectors.toList());
    }

}
