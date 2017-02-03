package interviewquestions.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sherxon on 2/2/17.
 */
public class WordDictionary {

    /**
     * Initialize your data structure here.
     */
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode('0');
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search(".at"));
        wordDictionary.addWord("bat");
        System.out.println(wordDictionary.search(".at"));
        System.out.println(wordDictionary.search("an."));
        System.out.println(wordDictionary.search("a.d."));
        System.out.println(wordDictionary.search("b."));
        System.out.println(wordDictionary.search("a.d"));
        System.out.println(wordDictionary.search("."));

    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode t = root;
        for (int i = 0; i < word.length(); i++) {
            int id = word.charAt(i) - 'a';
            if (t.children[id] == null)
                t.children[id] = new TrieNode(word.charAt(i));
            t = t.children[id];
        }
        t.isWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {

        Set<TrieNode> set = new HashSet<>();
        set.add(root);
        for (int i = 0; i < word.length(); i++) {

            if (word.charAt(i) == '.') {
                Set<TrieNode> temp = new HashSet<>();
                for (TrieNode trieNode : set) {
                    for (int j = 0; j < trieNode.children.length; j++) {
                        if (trieNode.children[j] != null) {
                            temp.add(trieNode.children[j]);
                            if (i == word.length() - 1 && trieNode.children[j].isWord) return true;
                        }

                    }
                }
                set = temp;
            } else {
                Set<TrieNode> temp = new HashSet<>();
                boolean b = false;
                for (TrieNode trieNode : set) {
                    int id = word.charAt(i) - 'a';
                    if (trieNode.children[id] != null) {
                        temp.add(trieNode.children[id]);
                        b = true;
                        if (i == word.length() - 1 && trieNode.children[id].isWord) return true;
                    }
                }
                if (!b) return false;
                set = temp;
            }

        }

        return false;
    }

    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        char val;
        boolean isWord;

        public TrieNode(char v) {
            val = v;
        }
    }
}
