package problems.medium;

import java.util.Arrays;

/**
 * @author Sherali Obidov.
 */
public class MininumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {
        System.out.println(findMinArrowShots(new int[][]{
                {3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}
        }));
    }
    static int findMinArrowShots(int[][] points) {
        if(points==null || points.length==0)return 0;
        if(points.length==1)return 1;

        Arrays.sort(points, (a, b)->{
            int k=a[0]-b[0];
            if(k==0)return a[1]-b[1];
            return k;
        });

        int j=0;
        int count=0;
        for(int i=1; i<points.length; i++){
            if(points[i][0]<=points[j][1]){
                points[j][0]=Math.max(points[i][0], points[j][0]);
                points[j][1]=Math.min(points[i][1], points[j][1]);
                count++;
            }else{
                j=i;
            }
        }
        return points.length-count;
    }
}
