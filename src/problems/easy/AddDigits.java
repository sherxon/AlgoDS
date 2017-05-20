package problems.easy;

/**
 * Created by sherxon on 2016-12-23.
 */

/**
 * Problem: Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * Solution: Read About Digital root in wikipedia.
 */
public class AddDigits {
    public int addDigits(int num) {
        return num == 0 ? 0 : (num % 9 == 0 ? 9 : num % 9);
    }
}
