package problems.medium;

import java.util.Arrays;
import java.util.LinkedList;

public class CoinChange {

    int count=Integer.MAX_VALUE;
    boolean found=false;

    /**
    * This is brute force accepted solution with a lot of pruning.
    * In most cases, this almost exponential solution is not accepted
    * Idea is generating all possible permutations and pruning by avoiding some cases
    * */
    public int coinChange2(int[] a, int n) {
        if(a==null || a.length==0)return -1;
        Arrays.sort(a);
        findMinRecursive(a, n, a.length - 1, 0);
        return count==Integer.MAX_VALUE ? -1 : count;
    }
    private void findMinRecursive(int[] a, int n, int i, int c){
        if(n<0 || count <= c || i<0 || n/a[i] >= count) return; // pruning here
        
        if(n==0){
            found=true;
            count=Math.min(c, count);
            return;
        }
        if(a[i]<=n) // pruning here also
        findMinRecursive(a, n - a[i], i, c + 1);
        findMinRecursive(a, n, i - 1, c);
    }

    /**
    * This is DP solution, using bottom up approach we can identify how many coins take to make up given value.
    *
    * */
     public int coinChange(int[] coins, int value) {

        if(coins==null || coins.length==0)return -1;

        Arrays.sort(coins);

        int[] dp= new int[value+1];

        findMinRecursive(coins, value, dp);

        return dp[value] == Integer.MAX_VALUE ? -1 : dp[value];
    }
    int findMinRecursive(int []coins, int value, int[] dp){
        
        if(value<0) return Integer.MAX_VALUE;
        
        if(value==0)return 0; // if value is 0, we came up with solution then, just return
        
        if(dp[value]!=0) return dp[value]; // if already calculated, use it
        
        int min=Integer.MAX_VALUE;
        
        for(int i=0; i<coins.length; i++){
            int res= findMinRecursive(coins, value - coins[i], dp);
            min=Math.min(min, res);
        }
        
        if(min!=Integer.MAX_VALUE)
          dp[value]=min+1;
        else 
            dp[value]=Integer.MAX_VALUE;
        return dp[value];
    }
    
    
}
