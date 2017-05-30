package problems.easy;

/**
 * Created by sherxon on 2016-12-23.
 */
public class HammingDistance {
    public static int hammingDistance(int x,int y){
        return Integer.bitCount(x^y);
    }

    public int hammingDistance2(int x, int y) {

        String xs=Integer.toBinaryString(x);
        String ys=Integer.toBinaryString(y);
        String s1=makeBinary(xs, Math.max(xs.length(), ys.length()));
        String s2=makeBinary(ys, Math.max(xs.length(), ys.length()));
        int count=0;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i)!=s2.charAt(i))count++;
        }
        return count;
    }
    private  String makeBinary(String xs, int max) {
        StringBuilder s=new StringBuilder(xs);
        while (s.length()<max)
            s.insert(0, "0");
        return s.toString();
    }
}
