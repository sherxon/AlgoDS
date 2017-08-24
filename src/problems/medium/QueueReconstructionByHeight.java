package problems.medium;

import java.util.Arrays;

/**
 * @author Sherali Obidov.
 */
public class QueueReconstructionByHeight {
    public static void main(String[] args) {
        reconstructQueue(new int[][]{
                {7,0},
                {4,4},
                {7,1},
                {5,0},
                {6,1},
                {5,2},
        });
    }

    static int[][] reconstructQueue(int[][] people) {
        if(people==null || people.length == 0)return people;
        Arrays.sort(people, (a, b)-> {
            if(a[0]==b[0])return a[1]-b[1];
            return b[0]-a[0];
        });
        for(int i=1; i<people.length; i++){
            int[] current=people[i];
            int count=current[1]*-1;
            for(int j=i-1; j>=0; j--){
                if(people[j][0]>=current[0])
                    count++;
            }
            int j=i-1;
            while(j>=0 && count>0){

                people[j+1]=people[j];

                if(people[j][0]>current[0])
                    count--;
                j--;
            }
            people[j+1]=current;

        }
        return people;
    }
}
