package problems.easy;

/**
 * @author Sherali Obidov.
 */
public class JudgeRouteCircle {
    public boolean judgeCircle(String moves) {
        char[] a=moves.toCharArray();
        if(a.length==0)return true;
        if(a.length%2!=0)return false;
        int u=0; int d=0;
        int l=0; int r=0;
        for(int i=0; i<a.length; i++){
            char c=a[i];
            if(c=='U')u++;
            else if(c=='D')d++;
            else if(c=='L')l++;
            else r++;
        }
        return (l==r) && (u==d);
    }
}
