package problems.medium;

/**
 * Created by sherxon on 1/9/17.
 */
public class ReverseString {
    public static String reverseWords(String s) {
        StringBuilder sb= new StringBuilder();
        StringBuilder word= new StringBuilder();
        char[] a= s.trim().toCharArray();
        for(int i=0; i<a.length; i++){
            if(a[i]!=' ')word.append(a[i]);
            else if(word.length()>0) {
                sb.insert(0, word);
                sb.insert(0, " ");
                word.setLength(0);
            }
        }
        if(word.length()>0) {
            sb.insert(0, word);
            sb.insert(0, " ");
            word.setLength(0);
        }
        if(sb.length()>0)
        return sb.substring(1);
        else return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("    "));
    }
}
