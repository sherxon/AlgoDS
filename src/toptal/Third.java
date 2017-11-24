package toptal;

/**
 * Why Did you create this class? what does it do?
 */
public class Third {
    public int solution(int[] a) {
        // write your code in Java SE 8
        // 1,5,4,9,8,7,12,13,14
        // 0,1,0,2,1,0,0,0,0
        // 1,2,3,4,5,6,0
        if (a == null || a.length == 0)
            return 0;
        if (a.length == 1)
            return 1;
        int count = 0;
        int min = Integer.MAX_VALUE;
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] < min) {
                count++;
                min = a[i];
            }
        }
        return count;
    }
}
