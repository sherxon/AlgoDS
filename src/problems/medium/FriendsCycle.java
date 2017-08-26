package problems.medium;

/**
 * @author Sherali Obidov.
 */
public class FriendsCycle {
        int count=0;
        int[] data;

        public int findCircleNum(int[][] a) {
            if(a==null || a.length == 0)return 0;
            data= new int[a.length+1];
            for(int i=0; i<data.length; i++){
                data[i]=i;
            }
            for(int i=0; i<a.length; i++){
                for(int j=0; j<a.length; j++){
                    if(a[i][j]==1){
                        //go(a, i, j); // second version, using recursion
                        //count++;
                        connect(i, j); // first version, using Union find data structure
                    }
                }
            }
            return data.length-count-1;
        }

        void connect(int i, int j){
            int ii=find(i);
            int jj=find(j);
            if(ii==jj)return;
            data[ii]=jj;
            count++;
        }

        int find(int i){
            while(data[i]!=i)
                i=data[i];
            return i;
        }

        /*
        * this is second version, recursive way
        *
        * */
        void go(int[][]a, int i, int j){
            if(i<0 || j< 0 || i>=a.length || j>=a[i].length )return;
            if(a[i][j]==0)return;
            a[i][j]=0;
            go(a, i, j+1);
            go(a, i, j-1);
            go(a, i+1, j);
            go(a, i-1, j);

        }
}
