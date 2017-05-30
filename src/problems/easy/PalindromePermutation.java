package problems.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sherxon on 4/28/17.
 */
public class PalindromePermutation {
    /**
    * To be palindrome, string needs to have even number of the same characters and/or single character.
    * */
    public boolean canPermutePalindrome(String s) {
        if(s.length()<=1)return true;
        Set<Character> set= new HashSet<>();

        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            if(!set.contains(c))
                set.add(c);
            else
                set.remove(c);
        }
        return set.size() <=1;
    }
}
