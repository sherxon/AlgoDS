package InterviewQuestions;

/**
 * Created by sherxon on 12/26/16.
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] a) {
        if(a.length==0)return 0;
        int mini=0;
        int maxi=0;
        int min=a[0];
        int max=a[0];
        int c=0;
        for(int i=0; i<a.length; i++){
            if(a[i]<min){
                min=a[i];
                mini=i;
            }
            if(a[i]>max || mini > maxi){
                max=a[i];
                maxi=i;
            }
            c=Math.max(c, max-min);

        }
        return c;

    }
}
