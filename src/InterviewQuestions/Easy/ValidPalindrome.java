package InterviewQuestions.Easy;

/**
 * Created by sherxon on 12/29/16.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s==null || s.length()==0)return true;
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            char left=s.charAt(i);
            char right=s.charAt(j);
            if(!Character.isLetterOrDigit(left))i++;
            else if(!Character.isLetterOrDigit(right))j--;
            else if(Character.toLowerCase(left)!=Character.toLowerCase(right))return false;
            else {
                i++;
                j--;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        int[] a={2,1,2,1,2};
        int count=0;
        int num=a[0];
        for (int i = 1; i < a.length; i++) {
            if(a[i]==a[i-1]){
                count++;
                num=a[i];
            }else if(count>0)count--;
        }
        System.out.println(num);
    }
}
