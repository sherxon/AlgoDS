package algo.string;

/**
 * Created by sherxon on 4/20/17.
 */
public class ReplaceString {
    public static void main(String[] args) {
        System.out.println(replaceAll("x%20x%20", "%2", "c"));
    }
    static String replaceAll(String s, String s1, String s2){
        StringBuilder sb= new StringBuilder();
        char[] a= s.toCharArray();
        for (int i = 0; i < a.length; i++) {
            char current=a[i];
            if(current!=s1.charAt(0)){
                sb.append(current);
                continue;
            }
            int j = 0;
            for (; j < s1.length(); j++) {
                if(i+j >= a.length ||  s1.charAt(j) != a[i+j]){
                    break;
                }
            }
            if(j==s1.length()){ // contains substring
                sb.append(s2);
                i+=s1.length()-1;
            }else{
                sb.append(current); // need to add current
            }
        }
        return sb.toString();
    }
}
