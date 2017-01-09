package interviewquestions.easy;

/**
 * Created by sherxon on 12/26/16.
 */
public class RemoveZeroes {
    public void moveZeroes(int[] a) {
        int j=0;
        for(int i=0; i<a.length; i++)
            if(a[i]!=0)a[j++]=a[i];

        for(int i=j; i<a.length; i++)
            a[i]=0;

    }
}
