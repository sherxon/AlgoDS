package problems.easy;

/**
 * Why Did you create this class? what does it do?
 */
public class RotateString {

    static boolean rotateString(String a, String b) {
        if (a == null || b == null || a.length() != b.length())
            return false;
        int c = -1;
        while ((c = a.indexOf(b.charAt(0), c + 1)) != -1) {
            String suba = a.substring(c, a.length());
            if (suba.equals(b.substring(0, suba.length())) &&
                a.substring(0, a.length() - suba.length()).equals(b.substring(suba.length(), b.length())))
                return true;
        }
        return false;
    }
}
