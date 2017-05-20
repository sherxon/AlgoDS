package problems.easy;

/**
 * Created by sherxon on 4/15/17.
 */
public class ShortestWordDistance {
    public static void main(String[] args) {
        new ShortestWordDistance().shortestDistance(new String[]{"a","b","c","d","d"},"a", "d");
    }

    public int shortestDistance(String[] a, String word1, String word2) {
        int index1=-1;
        int index2=-1;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<a.length; i++){
            if(word1.equals(a[i]))index1=i;
            else if(word2.equals(a[i]))index2=i;
            if(index1!=-1 && index2!=-1)
                min=Math.min(min, Math.abs(index1-index2));
        }
        return min;
    }
}
