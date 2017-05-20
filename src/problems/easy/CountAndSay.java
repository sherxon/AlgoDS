package problems.easy;

/**
 * Created by sherxon on 1/16/17.
 */
public class CountAndSay {
    /**
     * We build the count and say sequence starting from 1.
     */
    public static String countAndSay(int n) {
        if(n == 1) return "1";
        else if(n == 2) return "11";
        StringBuilder sb= new StringBuilder("11");
        for(int i=3; i<=n; i++){
            char[] a=sb.toString().toCharArray();
            sb.setLength(0);
            char current=a[0];
            int count=0;
            for(int j=0; j<a.length; j++){
                if(a[j] == current){
                    count++;
                }else{
                    sb.append(count).append(current);
                    count=1;
                    current=a[j];
                }
            }
            sb.append(count).append(current);
        }
        return sb.toString();
    }
}
