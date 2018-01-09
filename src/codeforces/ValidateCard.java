package codeforces;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Why Did you create this class? what does it do?
 */
public class ValidateCard {

    static List<Map<String, Object>> validateCards(String[] bannedPrefixes, String[] cardsToValidate) {

        return Arrays.stream(cardsToValidate).
                map(e -> ToMap(e, bannedPrefixes)).collect(Collectors.toList());

    }

    private static Map<String, Object> ToMap(String e, String[] bannedPrefixes) {
        Map<String, Object> map = new HashMap<>();
        map.put("card", e);
        map.put("isValid", isValid(e));
        map.put("isAllowed", isAllowed(e, bannedPrefixes));
        return map;
    }

    private static boolean isAllowed(String e, String[] bannedPrefixes) {
        for (String bannedPrefix : bannedPrefixes) {
            if (e.startsWith(bannedPrefix))
                return false;
        }
        return true;
    }

    private static boolean isValid(String e) {
        int sum = 0;
        for (int i = 0; i < e.length() - 1; i++) {
            sum += (e.charAt(i) - '0') * 2;
        }

        return sum % 10 == e.charAt(e.length() - 1) - '0';
    }
}
