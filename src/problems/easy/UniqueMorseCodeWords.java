package problems.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Why Did you create this class? what does it do?
 */
public class UniqueMorseCodeWords {
    public static void main(String[] args) {
        System.out.println(uniqueMorseRepresentations(new String[] {
                "gin", "zen", "gig", "msg"
        }));
    }

    static String[] codes = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...",
                                           "-",
                                           "..-", "...-", ".--", "-..-", "-.--", "--.." };

    static public int uniqueMorseRepresentations(String[] words) {
        if (words == null || words.length == 0)
            return 0;

        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            set.add(parse(words[i]));
        }
        return set.size();
    }

    private static String parse(String word) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            builder.append(codes[word.charAt(i) - 'a']);
        }
        return builder.toString();
    }
}
