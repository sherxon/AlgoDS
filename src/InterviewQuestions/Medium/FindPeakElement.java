package InterviewQuestions.Medium;

/**
 * Created by sherxon on 12/30/16.
 */
public class FindPeakElement {
    public int findPeakElement(int[] a) {
        int i=0;
        int j=a.length-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(mid>0 && mid<a.length-1 && a[mid]>=a[mid-1] && a[mid]>=a[mid+1])return mid;
            if(mid<a.length-1 && a[mid]<a[mid+1])i=mid+1;
            else j=mid-1;
        }
        return i;
    }
}
