package InterviewQuestions;

/**
 * Created by sherxon on 12/29/16.
 */
public class GuessNumberHigherorLower {
    public int guessNumber(int n) {
        int i=1;
        int j=n;
        while(i<=j){
            int mid=i+(j-i)/2;
            int g=guess(mid);
            if(g==0)return mid;
            else if(g==1)i=mid+1;
            else j=mid-1;
        }
        return -1;
    }

    private int guess(int mid) {
        return 1;
    }
}
