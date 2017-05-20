package problems.easy;

/**
 * Created by sherxon on 2016-12-28.
 */
public class CountPrimes {
    public int countPrimes(int n) {
        if(n<2)return 0;
        boolean[] a= new boolean[n];
        a[0]=true;
        a[1]=true;
        for(int i=2; i<Math.sqrt(n); i++){
            if(!a[i]){
                for(int j=i*2; j<n; j+=i)
                    a[j]=true;
            }
        }
        int c=0;
        for(int i=0; i<n; i++)
            if(!a[i])c++;
        return c;
    }
}
