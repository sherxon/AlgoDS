package problems.medium;

/**
 * Created by sherxon on 4/19/17.
 */
public class MetaStrings {
    public static void main(String[] args) {
        System.out.println(isMetaString("geeks", "keegs")); // true
        System.out.println(isMetaString("rsting", "string")); // false
        System.out.println(isMetaString("Converse", "Conserve")); //true
    }

    static boolean isMetaString(String a, String b){
        if(a.length()!=b.length())return false;
        long sum=0;
        long sum2=0;
        int diffCount=0;
        for (int i = 0; i < a.length(); i++) {
            int aa=a.charAt(i)-'a';
            int bb=b.charAt(i)-'a';
            sum+=aa;
            sum2+=bb;
            diffCount+= aa == bb ? 0 : 1;
        }
        return sum==sum2 && diffCount<=2;
    }
}
