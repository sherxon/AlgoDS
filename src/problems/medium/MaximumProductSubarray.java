package problems.medium;

/**
 * Created by sherxon on 2016-12-30.
 */
public class MaximumProductSubarray {
    public static void main(String[] args) {
       int a= new MaximumProductSubarray().maxProduct(new int[]{-2,0});
        System.out.println(a);
    }
    public int maxProduct(int[] a) {
        if(a==null || a.length==0)return 0;
        if(a.length==1)return a[0];
        int max=Integer.MIN_VALUE;

        int sum2=1;
        int sum=1;
        int minus=0;
        int lastminus=1;
        for (int i = 0; i < a.length; i++) {
            if(a[i]<0){
                minus++;
                if(minus%2!=0){
                    sum=sum2;
                   sum2=1;
                }else{
                    sum*=sum2*lastminus*a[i];
                }
                max=Math.max(max, sum2);
                max=Math.max(max, sum);
                lastminus=a[i];
                continue;
            }

            if(a[i]==0){
                if(minus%2!=0)sum2/=lastminus;
                max=Math.max(max, sum2);
                sum2=1;
                sum=1;
                minus=0;
                lastminus=1;
            }else{
                sum2*=a[i];
                max=Math.max(max, sum2);
            }
        }
        if(minus%2!=0)sum2/=lastminus;
        max=Math.max(max, sum2);
        return max;
    }

}
