package interviewquestions.easy;

/**
 * Created by sherxon on 12/27/16.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            if (alphabet[index] == 0) return false;
            alphabet[index]--;
        }
        return true;
    }
}
