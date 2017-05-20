package problems.medium;

/**
 * Created by sherxon on 2016-12-30.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] a) {
        if(a==null && a.length==0)return 0;
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[i].length; j++){
                if(i>0 && j>0)
                    a[i][j]=Math.min(a[i][j]+a[i][j-1],a[i][j]+a[i-1][j]);
                else if(i==0 && j>0)
                    a[i][j]=a[i][j-1]+a[i][j];
                else if(j==0 && i>0)
                    a[i][j]=a[i-1][j]+a[i][j];
            }
        }
        return a[a.length-1][a[0].length-1];
    }
}
