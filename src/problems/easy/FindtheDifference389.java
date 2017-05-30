package problems.easy;

/**
 * Created by sherxon on 2016-12-23.
 */
public class FindtheDifference389 {
    public static void main(String[] args) {
        System.out.println(new FindtheDifference389().findTheDifference("aad", "aadt"));
    }

    public char findTheDifference(String s, String t) {
        int sum1=0;
        int sum2=0;
        for (char c : s.toCharArray()) {
            sum1+=c;
        }
        for (char c : t.toCharArray()) {
            sum2+=c;
        }
       return (char)(sum2-sum1);
    }
}
