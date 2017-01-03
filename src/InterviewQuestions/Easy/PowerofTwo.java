package InterviewQuestions.Easy;

/**
 * Created by sherxon on 1/2/17.
 */
public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        if(n<1)return false;
        //return (n&(n-1)) == 0;
        return (n & (n-1)) == 0 && ((Integer.toBinaryString(n).length()-1) %2==0 );
    }
}
