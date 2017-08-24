package problems.medium;

/**
 * @author Sherali Obidov.
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        if(s==null || s.length()==0)return 0;

        int count=s.length();
        char[] a =s.toCharArray();

        for(int i=1; i<s.length(); i++){
            int p=i-1;
            int q=i+1;
            while(p>=0 && q<a.length){
                if(a[p]!=a[q])break;
                p--;
                q++;
                count++;
            }

            p=i-1;
            q=i;
            while(p>=0 && q<a.length){
                if(a[p]!=a[q])break;
                p--;
                q++;
                count++;
            }
        }

        return count;
    }
}
