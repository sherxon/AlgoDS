package problems.medium;

/**
 * Why Did you create this class? what does it do?
 */
public class CustomSortString {
    public String customSortString(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0)
            return "";
        int[] a = new int[26];
        for (int i = 0; i < t.length(); i++) {
            a[t.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            for (int j = 0; j < a[index]; j++) {
                sb.append((char) (index + 'a'));
            }
            a[index] = 0;
        }

        for (int i = 0; i < a.length; i++) {
            int index = i;
            for (int j = 0; j < a[index]; j++) {
                sb.append((char) (index + 'a'));
            }
            a[index] = 0;
        }
        return sb.toString();
    }
}
