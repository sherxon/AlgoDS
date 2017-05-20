package problems.easy;

/**
 * Created by sherxon on 2016-12-30.
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] a) {
        int p=0;
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[i].length; j++){
                if(a[i][j]==0)continue;
                p+=4;
                if(j>0 &&  a[i][j-1]==1)p--;
                if(j<a[i].length-1 && a[i][j+1]==1)p--;
                if(i>0 && a[i-1][j]==1)p--;
                if(i<a.length-1 && a[i+1][j]==1)p--;

            }

        }
        return p;
    }
}
