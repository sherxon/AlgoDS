package InterviewQuestions;

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
}
