package problems.easy;

/**
 * Created by sherxon on 2016-12-29.
 */
public class FirstbadVersion {
    public static void main(String[] args) {
        new FirstbadVersion().firstBadVersion(10);
    }
    public int firstBadVersion(int n) {
        int i=1;
        int j=n;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(isBadVersion(mid))
                j=mid-1;
            else
                i=mid+1;
        }
        System.out.println(i);
        return i;
    }

    private boolean isBadVersion(int mid) {
        return mid>=2;
    }

}
