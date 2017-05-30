package problems.easy;

/**
 * Created by sherxon on 5/4/17.
 */
public class RecursiveMultiply {
    public static void main(String[] args) {
        int n=calc(123, 211);
        System.out.println(n);
        System.out.println(123 * 211);
    }

    private static int calc(int n, int m) {
        if(m==0)return 0;
        int res=calc(n, m/10);
        int res1=0;
        for (int i = 0; i < 10; i++) {
            res1+=res;
        }
        return res1 + (n*(m%10));
    }

}
