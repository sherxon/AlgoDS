package problems.medium;

import java.util.Arrays;

/**
 * Why Did you create this class? what does it do?
 */
public class BoatstoSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        if (people == null || people.length == 0)
            return 0;
        if (people.length == 1)
            return 1;
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        int c = 0;
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
            c++;
        }
        return c;
    }
}
