package problems.easy;

/**
 * Why Did you create this class? what does it do?
 */
public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[] {
                'a', 'b'
        }, 'z'));
    }

    static public char nextGreatestLetter(char[] letters, char target) {
        int[] a = new int[26];
        int min = 0;
        for (int i = 0; i < letters.length; i++) {
            a[letters[i] - 'a']++;
        }
        for (int i = target - 'a' + 1; i < a.length; i++) {
            if (a[i] != 0)
                return (char) (i + 'a');
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0)
                return (char) (i + 'a');
        }
        return '0';
    }

}
