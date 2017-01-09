package interviewquestions.easy;

/**
 * Created by sherxon on 12/23/16.
 */
public class AddDigits258 {
    public int addDigits(int num) {
        return num==0 ? 0 : ( num % 9 == 0 ? 9 : num % 9);
    }
}
