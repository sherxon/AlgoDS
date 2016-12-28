package InterviewQuestions;

/**
 * Created by sherxon on 12/28/16.
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        if(num < 1)return false;

        while(num>1){
            if(num%2==0)num/=2;
            else if(num%3==0)num/=3;
            else if(num%5==0)num/=5;
            else return false;
        }
        return true;
    }
}
