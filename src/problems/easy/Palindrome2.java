package problems.easy;

/**
 * Why Did you create this class? what does it do?
 */
public class Palindrome2 {
    public static void main(String[] args) {
        System.out.println(validPalindrome("abca"));
    }
   static boolean validPalindrome(String s) {
        if(s==null ||s.length() <=2)return true;
        char[] a=s.toCharArray();
        int i=0;
        int j=a.length-1;
        int count=0;
        while(i<=j){
            if(a[i]!=a[j]){
                break;
            }
            i++;
            j--;
        }
        if(i>=j)return true;
        int ii=i;
        int jj=j;
        i++;
        while(i<=j){
            if(a[i]!=a[j]){
                break;
            }
            i++;
            j--;
        }
        if(i>=j)return true;
        i=ii;
        j=jj;
        j--;
        while(i<=j){
            if(a[i]!=a[j]){
                break;
            }
            i++;
            j--;
        }
        if(i>=j)return true;


        return false;

    }
}
