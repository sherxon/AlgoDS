package contests.contest30;

/**
 * Created by sherxon on 4/29/17.
 */
public class ReshapetheMatrix {
    public int[][] matrixReshape(int[][] a, int r, int c) {
        if(a.length == 0 || a[0].length == 0)return a;

        if( r*c != a.length * a[0].length)return a;

        int[][] b=new int[r][c];
        int ii=0;
        int jj=0;

        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[0].length; j++){
                if(jj==c){
                    jj=0;
                    ii++;
                }
                b[ii][jj++]=a[i][j];

            }
        }
        return b;

    }
}
