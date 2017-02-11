package interviewquestions.medium;

/**
 * Created by sherxon on 12/30/16.
 */
public class FindMinimuminRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(new FindMinimuminRotatedSortedArray().findMin(
                //new int[]{6,7,1,2,3,4,5}
                new int[]{4 ,5 ,6 ,7 ,0, 1, 2}
                //new int[]{3,4,5,6,7,1,2}
        ));
    }
    public int findMin(int[] a) {
        int i=0;
        int j=a.length-1;
        while (i<=j){
            int mid=i+(j-i)/2;
            if(i==mid || j==mid)return Math.min(a[i], Math.min(a[j], a[mid]));
            if(a[mid]>a[j])i=mid;
            else if(a[mid]<a[j])j=mid;
            else return a[i];
        }
        return a[i];
    }
}
