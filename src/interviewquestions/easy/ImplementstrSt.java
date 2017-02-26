package interviewquestions.easy;

/**
 * Created by sherxon on 2/26/17.
 */
public class ImplementstrSt {
    /**
     * There are two solutions for this problem. One is using RabinKarp Algorithm and the second one is using
     * Java's index of algorithm i.e searching starting point of needle from haystack and comparing neeedle.
     * Time complexity in both algorithms is average O(n+m) and in the worst case O(mn);
     */

    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;
        if (needle.length() == 0) return 0;
        //return rk(haystack, needle);
        return indexOf(haystack, needle);
    }

    int indexOf(String hay, String ne) {
        int i = 0;
        int ii = ne.charAt(0);
        while (i < hay.length()) {
            while (i < hay.length() && hay.charAt(i) != ii) i++;

            if (i + ne.length() <= hay.length() && hay.substring(i, i + ne.length()).equals(ne)) return i;
            i++;
        }
        return -1;
    }

    int rk(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;
        int m = needle.length();
        int n = haystack.length();
        int h = hash(needle);
        int hh = hash(haystack.substring(0, m));
        for (int i = 0; i <= n - m; i++) {
            System.out.println(h + " " + hh + " " + haystack.substring(i, i + m));
            if (h == hh && haystack.substring(i, i + m).equals(needle)) return i;
            if (i < n - m)
                hh = rehash(haystack, i, hh, m - 1);
        }
        return -1;
    }

    int hash(String s) {
        int h = 0;
        int prime = 31;
        for (int i = 0; i < s.length(); i++) {
            h += Math.pow(prime, i) * s.charAt(i);
        }
        return h;
    }

    int rehash(String s, int i, int old, int len) {
        int h = (old - s.charAt(i)) / 31;
        h += Math.pow(31, len) * s.charAt(i + len + 1);
        return h;
    }
}
