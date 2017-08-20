package problems.easy;

/**
 * @author Sherali Obidov.
 */
public class ImageSmoother {
    public int[][] imageSmoother(int[][] a) {
        if(a==null || a.length==0)return a;
        int[][] b=new int[a.length][a[0].length];

        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[i].length; j++){
                int c=c(a, i, j);
                int val=v(a, i, j);
                // System.out.println(val + " " + i + " " + j + " " + c);
                b[i][j]=(int)(Math.floor( (val*1.0)/c));
            }
        }
        return b;
    }
    int v(int[][]a, int i, int j){
        int c=a[i][j];
        if(i>0)c+=a[i-1][j];
        if(j>0)c+=a[i][j-1];
        if(i<a.length-1)c+=a[i+1][j];
        if(j<a[i].length-1)c+=a[i][j+1];

        if(i>0 && j>0)c+=a[i-1][j-1];
        if(i<a.length-1 && j<a[i].length-1)c+=a[i+1][j+1];
        if(i<a.length-1 && j>0)c+=a[i+1][j-1];
        if(i>0 && j<a[i].length-1)c+=a[i-1][j+1];
        return c;

    }
    int c(int[][]a, int i, int j){
        int c=1;
        if(i>0)c+=1;
        if(j>0)c+=1;
        if(i<a.length-1)c+=1;
        if(j<a[i].length-1)c+=1;

        if(i>0 && j>0)c+=1;
        if(i<a.length-1 && j<a[i].length-1)c+=1;
        if(i<a.length-1 && j>0)c+=1;
        if(i>0 && j<a[i].length-1)c+=1;
        return c;

    }
}
