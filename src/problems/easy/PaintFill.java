package problems.easy;

/**
 * Created by sherxon on 5/5/17.
 */
public class PaintFill {

    void paint(int[][] a, int i,int j, int color){
        if(a.length ==0 || a[0].length == 0)return;
        int orColor=a[i][j];
        helper(a, i, j, color, orColor);
    }

    private void helper(int[][] a, int i, int j, int color, int orColor) {
        if(i<0 || i>=a.length || j<0 || j>=a[i].length)return; // off limit
        if(a[i][j]!=orColor)return; // different color start
        a[i][j]=color;
        helper(a, i+1, j, color, orColor);
        helper(a, i-1, j, color, orColor);
        helper(a, i, j+1, color, orColor);
        helper(a, i, j-1, color, orColor);
    }
}
