package problems.easy;

/**
 * Created by sherxon on 2016-12-26.
 */

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines,
 * write a function that will return true if the ransom note can be constructed from the magazines ;
 * otherwise, it will return false.
 * Each letter in the magazine string can only be used once in your ransom not
 */

public class RansomNote {

    /**
     * The idea is to create an array with length of 26 (English letters) and store each frequency of each letter.
     * and remove ransom note letters from array. if certain character count in array is 0, that means ransom note has a
     * character that is not included on magazine.
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] a = new int[26];

        for (char c : magazine.toCharArray()) {
            a[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (a[c - 'a'] == 0) return false;
            a[c - 'a']--;
        }
        return true;
    }
}
