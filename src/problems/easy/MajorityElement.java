package problems.easy;

/**
 * Created by sherxon on 2016-12-30.
 */
// 1) using soring, 2) using quick select 3) given below
public class MajorityElement {
    public int majorityElement(int[] a) {
        // Arrays.sort(a);
        // return a[a.length/2];
        int m=a[0];
        int count=0;
        for(int i=0; i<a.length; i++){
            if(count==0){
                m=a[i];
                count++;
            }else if(a[i]==m)count++;
            else count--;
        }
        return m;
    }
}
