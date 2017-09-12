package problems.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Why Did you create this class? what does it do?
 */
public class MagicDictionary {
    Set<String> set;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        set=new HashSet<>();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String s:dict){
            set.add(s);
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        char[] a=word.toCharArray();
        for(int i=0; i<a.length; i++){
            for(int j=0; j<26; j++){
                if(a[i]!=(char)(j+'a')){
                    char temp=a[i];
                    a[i]=(char)(j+'a');
                    String s=new String(a);
                    if(set.contains(s))return true;
                    a[i]=temp;
                }

            }
        }
        return false;
    }
}
