package problems.medium;

/**
 * Created by sherxon on 1/2/17.
 */
// this also can be solved using newtons method, MIT 6.006 lec 12-13
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if(num<1)return false;
        if(num==1)return true;
        int temp=num;
        long i=1;
        long j=1;
        while(temp>=1){
            temp/=10;
            j*=10;
        }
        while(i<=j){
            long mid=i+(j-i)/2;
            if(mid*mid==num)return true;
            else if(mid*mid > num)j=mid-1;
            else i=mid+1;
        }
        return false;
    }
}
