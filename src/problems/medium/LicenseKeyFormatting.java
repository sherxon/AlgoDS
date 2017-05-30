package problems.medium;

/**
 * Created by sherxon on 1/7/17.
 */
public class LicenseKeyFormatting {
    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("---", 3));
    }

    public static String licenseKeyFormatting(String s, int k) {
        if (k==0 || s.length()==0)return s;
        StringBuilder sb =new StringBuilder();
        StringBuilder sb2 =new StringBuilder();
        char[] ch=s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if(ch[i]!='-') sb.append(Character.toUpperCase(ch[i]));
        }
        if(sb.length()==0)return "";
        int rem=sb.length()%k;
        if(rem>0){
            sb2.append(sb.substring(0, rem));
            sb2.append("-");
        }
        int j=1;
        for (int i = rem; i < sb.length(); i++) {
            sb2.append(sb.charAt(i));
            if(j++%k==0)sb2.append("-");
        }

        return sb2.substring(0, sb2.length()-1);

    }
}
