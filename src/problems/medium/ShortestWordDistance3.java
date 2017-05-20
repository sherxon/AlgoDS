package problems.medium;

/**
 * Created by sherxon on 4/15/17.
 */
public class ShortestWordDistance3 {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int min=Integer.MAX_VALUE;
        if(!word1.equals(word2)){
            int index1=-1;
            int index2=-1;
            for(int i=0; i<words.length; i++){
                if(words[i].equals(word1))index1=i;
                else if(words[i].equals(word2))index2=i;
                if(index1!=-1 && index2!=-1)
                    min=Math.min(min, Math.abs(index1-index2));
            }
        }else{
            int p=-1;
            int cur=-1;
            for(int i=0; i<words.length; i++){
                if(words[i].equals(word1)){
                    p=cur;
                    cur=i;
                }
                if(p!=-1 && cur!=-1)
                    min=Math.min(min, cur-p);
            }
        }
        return min;

    }
}
