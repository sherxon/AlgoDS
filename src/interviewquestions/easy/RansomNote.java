package interviewquestions.easy;

/**
 * Created by sherxon on 12/26/16.
 */
public class RansomNote {
    public boolean canConstruct(String r, String m) {
        if(r.length()>m.length())return false;
        int[] a= new int[26];

        for(char c:m.toCharArray()){
            a[c-'a']++;
        }
        for(char c:r.toCharArray()){
            if(a[c-'a']==0)return false;
            a[c-'a']--;
        }
        return true;
    }
}
