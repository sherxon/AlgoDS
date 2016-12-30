package InterviewQuestions.Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sherxon on 12/28/16.
 */
public class FindAllAnagramsinString {
    public static void main(String[] args) {
        new FindAllAnagramsinString().findAnagrams("cbaebabacd", "abc");
    }
    public List<Integer> findAnagrams(String s, String p){
        List<Integer> list= new ArrayList<>();
        int[] a= new int[26];
        if(s==null || s.length()==0 || p==null || p.length()==0)return list;
        for (char c:p.toCharArray())
            a[c-'a']++;

        int start=0;
        int end=0;
        int count=p.length();
        while (end<s.length()){
            if(a[s.charAt(end)-'a']>=1)count--;

            a[s.charAt(end)-'a']--;
            end++;

            if(count==0)
                list.add(start);

            if(end-start==p.length()){
                if(a[s.charAt(start)-'a']>=0)
                    count++;
                a[s.charAt(start)-'a']++;
                start++;
            }

        }

        return list;
    }
}
