package problems.easy;

/**
 * Created by sherxon on 1/6/17.
 */
public class ConvertaNumbertoHexadecimal {
    public static void main(String[] args) {
       int n=0;
        String s=convert(n);
        System.out.println(Integer.toHexString(n));
        System.out.println(s);
    }

    private static String convert(int i) {
        StringBuilder builder= new StringBuilder();
        if(i<0){

        }else{
            while (i!=0){
                builder.insert(0, Integer.toHexString(i % 16));
                i/=16;
            }
        }
        return builder.toString();
    }
}
