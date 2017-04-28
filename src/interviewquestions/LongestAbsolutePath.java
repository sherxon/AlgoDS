package interviewquestions;

/**
 * Created by sherxon on 4/27/17.
 */
public class LongestAbsolutePath {


    public int lengthLongestPath(String input) {
        if(input.length()==0)return 0;
        int max=0;
        String[] a= input.split("\\n");
        int[] map= new int[a.length];

        for(int i=0; i<a.length; i++){
            int count = tabCount(a[i].toCharArray());
            map[i] = a[i].length();
            for(int j = i-1; j>=0; j--){
                int tc = tabCount(a[j].toCharArray());
                if(tc == count - 1){
                    map[i]=map[j] + 1 + a[i].length() - count;
                    break;
                }
            }
            if(a[i].contains("."))  max= Math.max(map[i], max);

        }

        return max;
    }
    int tabCount(char[] a){
        int count=0;
        int i=0;
        while(a[i] == '\t') {
            i++;
            count++;
        }
        return count;
    }
}
