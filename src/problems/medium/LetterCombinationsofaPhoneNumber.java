package problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sherxon on 1/11/17.
 */
public class LetterCombinationsofaPhoneNumber {


    List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>();
        List<String> list = new ArrayList<>();
        getF(digits, 0, "", list);
        return list;
    }

    private void getF(String s, int i, String sf, List<String> list) {
        if (i == s.length()) {
            list.add(sf);
            return;
        }
        String ss = getMap(i, s);
        for (int k = 0; k < ss.length(); k++) {
            getF(s, i + 1, sf + ss.charAt(k), list);
        }

    }

    String getMap(int i, String s) {
        int c = s.charAt(i) - '0';
        String letters = "";
        switch (c) {
            case 2:
                letters = "abc";
                break;
            case 3:
                letters = "def";
                break;
            case 4:
                letters = "ghi";
                break;
            case 5:
                letters = "jkl";
                break;
            case 6:
                letters = "mno";
                break;
            case 7:
                letters = "pqrs";
                break;
            case 8:
                letters = "tuv";
                break;
            case 9:
                letters = "wxyz";
                break;
        }
        return letters;
    }
}
