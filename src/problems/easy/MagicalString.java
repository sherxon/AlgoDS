package problems.easy;

/**
 * Created by sherxon on 1/7/17.
 */
public class MagicalString {
    public static void main(String[] args) {
        System.out.println(magicalString(8));
    }

    public static int magicalString(int n) {
        if(n==0)return 0;
        if(n==1)return 1;
        StringBuilder sb= new StringBuilder(n);
        sb.append("122");
        int count=1;
        int i=2;
        while (sb.length()<n){
            if(sb.charAt(i)=='1'){
                boolean one=sb.charAt(sb.length()-1) =='1';
                count+=one ? 0: 1;
                sb.append(one ? 2 : 1);
            }else{
                boolean one=sb.charAt(sb.length()-1) =='1';
                count+=one ? 0: 2;
                sb.append(one ? 22 : 11);
            }
            i++;
        }
        System.out.println(sb);
        if(sb.length()>n && sb.charAt(sb.length()-1)=='1')count--;
        return count;
    }
}
