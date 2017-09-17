package problems.medium;

import java.util.HashMap;
import java.util.Map;

public class MapSum {
    public static void main(String[] args) {
        MapSum mapSum= new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("b"));
    }


    TrieNode root = new TrieNode('0');
    Map<String, Integer> map;

    /** Initialize your data structure here. */
    public MapSum() {
        map= new HashMap<>(1000);
    }

    public void insert(String key, int val) {
        map.put(key, val);
        insert(key);
    }

    public int sum(String prefix) {
        TrieNode node=startsWith(prefix);
        if(node==null)return 0;
        return summ(node, prefix);
    }
    int summ(TrieNode node, String pr){
        int sum=node.isWord ? map.get(pr) : 0;
        for (int i = 0; i < node.children.length; i++) {
            if (node.children[i] != null)
                sum+=summ(node.children[i], pr+node.children[i].val);
        }
        return sum;
    }
    public TrieNode startsWith(String word) {
        TrieNode t = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (t.children[index] == null) return null;
            t = t.children[index];
        }
        return t;
    }
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
    private class TrieNode {
        char val;
        boolean isWord;
        private TrieNode[] children = new TrieNode[26];

        public TrieNode(char c) {
            val = c;
        }
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */