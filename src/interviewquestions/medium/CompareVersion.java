package interviewquestions.medium;

/**
 * Created by sherxon on 3/2/17.
 */
public class CompareVersion {

    public int compareVersion(String version1, String version2) {
        String[] s = version1.split("\\."); //  \\. regex dot
        String[] s2 = version2.split("\\.");

        int max = Math.max(s.length, s2.length);

        for (int i = 0; i < max; i++) {
            if (i >= s.length) {
                boolean b = true;
                for (int j = i; j < s2.length; j++) {
                    if (Integer.parseInt(s2[j]) != 0) {
                        b = false;
                        break;
                    }
                }
                if (b) return 0;
                return -1;

            }
            if (i >= s2.length) {
                boolean b = true;
                for (int j = i; j < s.length; j++) {
                    if (Integer.parseInt(s[j]) != 0) {
                        b = false;
                        break;
                    }
                }
                if (b) return 0;
                return 1;
            }
            Integer fi = Integer.parseInt(s[i]);
            Integer se = Integer.parseInt(s2[i]);
            if (fi > se) return 1;
            if (se > fi) return -1;
        }
        return 0;
    }
}
