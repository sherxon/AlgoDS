package InterviewQuestions.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sherxon on 1/5/17.
 */
public class FindAllDuplicatesinanArray {
    public List<Integer> findDuplicates(int[] a) {
        List<Integer> list=new ArrayList<>();
        for(int i=0; i<a.length; ++i){
            int index=Math.abs(a[i])-1;
            if(a[index]<0)
                list.add(Math.abs(index+1));
            a[index]=-a[index];
        }
        return list;
    }
}
