public class Solution {
    int count=Integer.MAX_VALUE;
    boolean found=false;
    public int coinChange2(int[] a, int n) {
        if(a==null || a.length==0)return -1;
        Arrays.sort(a);
        go(a, n, a.length-1, 0);
        return count==Integer.MAX_VALUE ? -1 : count;
    }
    private void go(int[] a, int n, int i, int c){
        if(n<0 || count <= c || i<0 || n/a[i] >= count) return;
        
        if(n==0){
            found=true;
            count=Math.min(c, count);
            return;
        }
        if(a[i]<=n)
        go(a, n-a[i], i, c+1);
        go(a, n, i-1, c);
    }
    
     public int coinChange(int[] a, int n) {
        if(a==null || a.length==0)return -1;
        Arrays.sort(a);
        int[] b= new int[n+1]; 
        go(a, n, b);
        //System.out.println(Arrays.toString(b));
        return b[n] == Integer.MAX_VALUE ? -1 : b[n]; 
    }
    int go(int []a, int n, int[] b){
        
        if(n<0) return Integer.MAX_VALUE;
        
        if(n==0)return 0;
        
        if(b[n]!=0) return b[n];
        
        int min=Integer.MAX_VALUE;
        
        for(int i=0; i<a.length; i++){
            int res=go(a, n-a[i], b);
            min=Math.min(min, res);
        }
        
        if(min!=Integer.MAX_VALUE)
          b[n]=min+1;
        else 
            b[n]=Integer.MAX_VALUE;
        return b[n];
    }
    
    
}
