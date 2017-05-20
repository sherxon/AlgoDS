package problems.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sherxon on 2016-12-23.
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> list= new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if(i%3==0 && i%5==0)list.add("FizzBuzz");
            else if (i%3==0)list.add("Fizz");
            else if(i%5==0)list.add("Buzz");
            else list.add(String.valueOf(i));
        }
        return list;
    }
}
