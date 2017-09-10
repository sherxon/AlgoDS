package problems.medium;

/**
 * Why Did you create this class? what does it do?
 */
public class MaximumSwap {
    public int maximumSwap(int num) {
        char[] c=String.valueOf(num).toCharArray();
        for(int i=0; i<c.length; i++){
            int maxi=i;
            int max=(int)c[i];
            for(int j=i+1; j<c.length; j++){
                if(((int)c[j]) >= max){
                    max=(int)c[j];
                    maxi=j;
                }
            }
            if(c[maxi]!=c[i]){
                char temp=c[maxi];
                c[maxi]=c[i];
                c[i]=temp;
                break;
            }
        }

        return Integer.parseInt(new String(c));
    }
}
