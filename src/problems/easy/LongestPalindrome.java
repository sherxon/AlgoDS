package problems.easy;

/**
 * Created by sherxon on 2016-12-28.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] a= new int[52];
        int count=0;
        for(char c: s.toCharArray()){
            if(Character.isUpperCase(c)){
                a[c-'A']++;
                if(a[c-'A']%2==0)
                    count++;
            }else{
                a[c-'a'+26]++;
                if(a[c-'a'+26]%2==0)
                    count++;
            }

        }
        count*=2;
        return count<s.length() ? count+1 : count;

    }
}
