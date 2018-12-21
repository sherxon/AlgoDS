package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Sherali Obidov.
 */
public class QueueReconstructionByHeight {

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

    public int[][] reconstructQueue2(int[][] people) {
        if (people == null || people.length <= 1)
            return people;
        int[][] a = new int[people.length][];
        List<Integer>[] map = new List[1100];
        for (int i = 0; i < people.length; i++) {
            int index = people[i][0];
            if (map[index] == null)
                map[index] = new ArrayList<>();
            map[people[i][0]].add(people[i][1]);
        }
        for (int i = 0; i < map.length; i++) {
            place(a, i, map[i]);
        }
        return a;
    }

    void place(int[][] a, int h, List<Integer> nums) {
        if (nums == null || nums.size() == 0)
            return;
        for (Integer n : nums) {
            int count = 0;
            int i = 0;
            while (i < a.length) {
                if (a[i] == null && count >= n) {
                    break;
                }
                if (a[i] == null || a[i][0] >= h) {
                    count++;
                }
                i++;
            }
            a[i] = new int[] { h, n };
        }
    }
}
