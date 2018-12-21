package problems.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Why Did you create this class? what does it do?
 */
public class ShortEncodingofWords {
    public static void main(String[] args) {
        ShortEncodingofWords encodingofWords = new ShortEncodingofWords();
        System.out.println(encodingofWords.minimumLengthEncoding(new String[] {
                "time", "time", "time", "time"
        }));
        System.out.println(encodingofWords.minimumLengthEncoding(new String[] {
                "me", "time",
                }));
        System.out.println(encodingofWords.minimumLengthEncoding(new String[] {
                "time", "bell", "e", "me",
                }));

    }

    TrieNode root = new TrieNode('0');
    int res = 0;

    public int minimumLengthEncoding(String[] words) {
        if (words == null || words.length == 0)
            return 0;
        res = 0;
        root = new TrieNode('0');
        Arrays.sort(words, (a, b) -> {
            int d = b.length() - a.length();
            if (d == 0)
                return b.compareTo(a);
            return d;
        });
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            addWord(words[i], set);
        }
        return res;
    }

    void addWord(String s, Set<String> set) {
        if (!set.add(s))
            return;
        char[] a = s.toCharArray();
        TrieNode x = root;
        for (int i = a.length - 1; i >= 0; i--) {
            TrieNode child = x.children[a[i] - 'a'];
            if (child == null) {
                child = new TrieNode(a[i]);
            } else {
                if (child.isWord && child.count > 0)
                    res -= i + 1;
                child.count++;
            }
            if (i == 0 && !child.isWord) {
                if (child.count == 0)
                    res += a.length + 1;
                child.isWord = true;
            }
            x.children[a[i] - 'a'] = child;
            x = child;
        }
    }

    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        char val;
        int count = 0;
        boolean isWord = false;

        TrieNode(char v) {
            this.val = v;
        }
    }
}
