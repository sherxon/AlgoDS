package problems.medium;

/**
 * Created by sherxon on 1/5/17.
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        if(n==1 || n==2)return 1;
        if(n==3)return 2;
        if(n==4)return 4;
        int ts=n/3;
        int rem=n%3;
        if(rem==1){
            rem=4;
            if(ts>1)
                ts-=1;
        }else if(rem==0)rem=1;
        int sum=(int)(Math.pow(3, ts)*rem);
        return sum;
    }
}
