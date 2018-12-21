package problems.easy;

/**
 * Why Did you create this class? what does it do?
 */
public class JewelsAndStones {
    public int numJewelsInStones(String j, String s) {
        if (j == null || j.length() == 0 || s == null || s.length() == 0)
            return 0;

        int[] jj = new int[128];
        for (int i = 0; i < j.length(); i++) {
            jj[j.charAt(i)]++;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (jj[s.charAt(i)] != 0)
                count++;
        }
        return count;
    }
}
