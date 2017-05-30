package problems.easy;

/**
 * Created by sherxon on 1/29/17.
 */

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {

    /**
     * Simple approach to compare first, second, ... elements of every element in array with first element.
     * if any string with not equal character found, return prefix.
     */
    static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        int len = strs[0].length();
        int i = 0;
        for (; i < len; i++) {

            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i))
                    return strs[0].substring(0, i);
            }
        }
        return strs[0].substring(0, i);
    }
}
