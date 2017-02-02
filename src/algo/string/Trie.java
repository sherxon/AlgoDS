package algo.string;

/**
 * Created by sherxon on 2/2/17.
 */

/**
 * This is prefix truee, which consumes alot memory but very fast.
 */
public class Trie {

    TrieNode root = new TrieNode('0');

    /**
     * Initialize your data structure here.
     */
    public Trie() {
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode t = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (t.children[index] == null)
                t.children[index] = new TrieNode(word.charAt(i));
            t = t.children[index];
        }
        t.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode t = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (t.children[index] == null) return false;
            t = t.children[index];
        }
        return t.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String word) {
        TrieNode t = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (t.children[index] == null) return false;
            t = t.children[index];
        }
        return true;
    }

    private class TrieNode {
        char val;
        boolean isWord;
        private TrieNode[] children = new TrieNode[26];

        public TrieNode(char c) {
            val = c;
        }
    }
}







/*
This is recursive, one-class aproach, but it has small bug that I could not find it in 2 hours.
public class Trie {

    int[] a= new int[26];
    Trie[]  children =new Trie[26];
    boolean isWord=false;

    */
/**
 * Initialize your data structure here.  Inserts a word into the trie.  Returns if the word is in the trie.  Returns if there is any word in the trie that starts with the given prefix.
 *//*

    public Trie() {

    }

    */
/** Inserts a word into the trie. *//*

    public void insert(String word) {
        insert(word, 0);
    }

    private void insert(String word, int i) {
        int index=word.charAt(i)-'a';
        a[index]++;
        if(children[index]==null) children[index]=new Trie();
        if(i==word.length()-1)
            isWord=true;
        else
            children[index].insert(word, i + 1);

    }

    */
/** Returns if the word is in the trie. *//*

    public boolean search(String word) {
        return search(word, 0);
    }

    private boolean search(String word, int i) {
        int index=word.charAt(i)-'a';
        if(a[index]==0)return false;
        if(i==word.length()-1) return children[index].isWord;
        return children[index].search(word, i + 1);
    }

    */
/** Returns if there is any word in the trie that starts with the given prefix. *//*

    public boolean startsWith(String prefix) {
       return startsWith(prefix, 0);
    }

    private boolean startsWith(String prefix, int i) {
        int index=prefix.charAt(i)-'a';
        if(a[index]==0)return false;
        if(i==prefix.length()-1) return true;
        return children[index].startsWith(prefix, i + 1);
    }
}

*/
