package contests.contest30;

/**
 * Created by sherxon on 4/29/17.
 */
public class PermutationinString {
    public static void main(String[] args) {
        System.out.println(checkInclusion("oaa", "eidbraoo"));
    }
    static boolean checkInclusion(String s1, String s2) {
        if(s1.length() == 0 || s2.length() ==0)return false;
        if(s2.length() < s1.length())return false;
        int sum=0;
        for(int k=0; k<s1.length(); k++){
            sum+=s1.charAt(k);
        }
        char[] a=s2.toCharArray();
        int n=s1.length();
        int hash=0;
        for(int k=0; k<s1.length(); k++){
            hash+=s2.charAt(k);
        }
        int i=1;
        for(; i<=a.length-n; i++){
            if(hash == sum && check(s1, a, i-1)) return true;
            hash=hash(a, hash, i, n);
            System.out.println(hash + " " + a[i]);
        }
        return hash == sum && check(s1, a, i-1);
    }

    private static boolean check(String s1, char[] c, int i) {
        int[] a=new int[26];
        int[] b=new int[26];
        for (int j = 0; j < s1.length(); j++) {
            a[s1.charAt(j)-'a']++;
            b[c[i+j]-'a']++;
        }
        for (int j = 0; j < a.length; j++) {
            if(a[j]!=b[j])return false;
        }
        return true;
    }

    static int hash(char[] a, int old, int i, int n){
        old-=a[i-1];
        old+=a[i+n-1];
        return old;
    }
}
