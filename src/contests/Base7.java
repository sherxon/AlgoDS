package contests;

/**
 * Created by sherxon on 2/11/17.
 */
public class Base7 {
    public static void main(String[] args) {
        System.out.println(convertTo7(100));
    }
    //Line 4: error: cannot find symbol: method convertToBase7(int)

    static String convertTo7(int num) {
        return Long.toString(num, 7);
    }
}
