package algo.string;

/**
 * Created by sherxon on 1/12/17.
 */

/**
 * This is Rabin Karp substring match algorithm. Time complexity is O(MxN), where m is length of string
 * to be matched and N is substring length. Worst case happens when all hash codes are the same and string
 * equal method checks all combinations. This is very rare if good hash function is used.
 * The idea is simple, calculating hash code of substring and text at length of substring
 * and check if these hashes are equal and substrings are also the same. To optimize hashing each sub-sequence
 * we can use rolling hash function which is constant time hash generation algorithm
 */

public class RabinKarpSubsequenceSearch {
    int prime = 31;

    public static void main(String[] args) {
        RabinKarpSubsequenceSearch rks = new RabinKarpSubsequenceSearch();
        System.out.println(rks.searchPattern("Sherxon".toCharArray(), "n".toCharArray()));
        System.out.println(rks.searchPattern("Sherxon".toCharArray(), "xon".toCharArray()));
        System.out.println(rks.searchPattern("Sherxon".toCharArray(), "hs".toCharArray()));
        System.out.println(rks.searchPattern("Sherxon".toCharArray(), "erx".toCharArray()));
        System.out.println(rks.searchPattern("Sherxon".toCharArray(), "S".toCharArray()));

    }

    public int searchPattern(char[] text, char[] pattern) {
        int m = text.length;
        int n = pattern.length;
        int textHash = hash(text, n);
        int patternHash = hash(pattern, n);
        for (int i = 0; i <= m - n; i++) {
            if (patternHash == textHash && equal(text, pattern, i)) return i;
            if (i < m - n) textHash = reHash(textHash, text[i], text[i + n], n);

        }
        return -1;
    }

    private int reHash(int textHash, char first, char last, int length) {
        int h = (textHash - first) / prime;
        h += Math.pow(prime, length - 1) * last;
        return h;
    }

    private boolean equal(char[] text, char[] pattern, int from) {
        for (int i = 0; i < pattern.length; i++)
            if (text[i + from] != pattern[i])
                return false;
        return true;
    }

    private int hash(char[] s, int to) {
        int h = 0;
        for (int i = 0; i < to; i++) {
            h += Math.pow(prime, i) * s[i];
        }
        return h;
    }
}
