package interviewquestions.easy;

/**
 * Created by sherxon on 1/29/17.
 */
public class ReverseVowels {
    public String reverseVowels(String s) {
        char[] a = s.toCharArray();
        int i = 0;
        int j = a.length - 1;
        while (i < j) {
            while (i < a.length && !isVowel(a[i])) i++;
            while (j >= 0 && !isVowel(a[j])) j--;
            if (i < j) {
                char temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        return String.valueOf(a);
    }

    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
