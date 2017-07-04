
/**
 * Problem Statement: Maximum weight transformation of a given string
 * Given a string consisting of only A’s and B’s. We can transform the given string to another string by toggling any character. Thus many transformations of the given string are possible. The task is to find Weight of the maximum weight transformation.
 * <p>
 * Weight of a sting is calculated using below formula.
 * <p>
 * Weight of string = Weight of total pairs +
 * weight of single characters -
 * Total number of toggles.
 * <p>
 * Two consecutive characters are considered as pair only if they
 * are different.
 * Weight of a single pair (both character are different) = 4
 * Weight of a single character = 1
 * <p>
 * This problem was asked during an interview in Adobe.
 * <p>
 * First I provided a DP based solution and then a brute force solution.
 */

package algo.dp;

public class MaxWeightTransformation {


    /**
     * Dynamic Programming Solution.
     * str1[] : String array (str.toCharArray())
     * i: first index of string (0)
     * size: str.length() -1
     * lookup: int[str.length()] (initialize all lookup indexes with -1)
     */

    public int maxWeightTransformationDPSol(char str1[], int i, int size, int lookup[]) {
        // If the counter has gone past maximum size
        // of string, then return 0
        if (i > size)
            return 0;
        // If the counter is equal to the size of
        // string, then retun 1. Since, there is no point of string
        // transformation.
        if (i == size)
            return 1;

        // if the subproblem is already solved
        if (lookup[i] != -1)
            return lookup[i];

        // If pair is not made, weight gained is 1
        int res = 1 + maxWeightTransformationDPSol(str1, i + 1, size, lookup);

        // is pair is made
        if (i + 1 <= size) {
            // if consecutive elements are same
            // weight gained is 3 after transformation
            if (str1[i] == str1[i + 1]) {
                res = Math.max(res, 3 + maxWeightTransformationDPSol(str1, i + 2, size, lookup));
            } else if (str1[i] != str1[i
                    + 1]) { // if consecutive elements are different  weight gained is 4
                res = Math.max(res, 4 + maxWeightTransformationDPSol(str1, i + 2, size, lookup));
            }
        }
        return lookup[i] = res;
    }

    /**
     * Brute Force Solution
     * str1[] : String array (str.toCharArray())
     * i: first index of string (0)
     * size: str.length() -1
     */
    public int maxWeightTransformationNoDPSol(char str1[], int i, int size) {
        // If the counter has gone past maximum size
        // of string, then return 0
        if (i > size)
            return 0;

        // If the counter is equal to the size of
        // string, then retun 1. Since, there is no point of string
        // transformation.
        if (i == size)
            return 1;

        // If pair is not made, weight gained is 1
        int res = 1 + maxWeightTransformationNoDPSol(str1, i + 1, size);

        // is pair is made
        if (i + 1 <= size) {
            if (str1[i] == str1[i
                    + 1]) {// if consecutive elements are same, weight gained is 3 after transformation
                res = Math.max(res, 3 + maxWeightTransformationNoDPSol(str1, i + 2, size));
            } else if (str1[i] != str1[i
                    + 1]) {// if consecutive elements are different,  weight gained is 4
                res = Math.max(res, 4 + maxWeightTransformationNoDPSol(str1, i + 2, size));
            }
        }

        return res;
    }
}


