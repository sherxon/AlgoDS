package problems.easy;

/**
 * Created by sherxon on 2016-12-26.
 */
public class RemoveElement {
    public int removeElement(int[] a, int val) {
        if(a.length==0)return 0;
        int v=0;
        for(int i=0; i<a.length; i++){
            if(a[i]==val)v++;
            else a[i-v]=a[i];

        }
        return a.length-v;
    }
}
