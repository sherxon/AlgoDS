package ds;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by sherxon on 6/4/17.
 */
interface hello {

  int a = 2;
}

public class SkipList {

  public static void main(String[] args) {

    Function<String, Integer> fn = Integer::parseInt;
    Predicate<String> predicate = s -> true;
    Supplier<String> supplier = () -> "";
    Consumer<String> consumer = System.out::println;
    BinaryOperator<String> binaryOperator = (String s, String s2) -> "";
    ForkJoinPool pool = new ForkJoinPool(4);
    ExecutorService service = Executors.newSingleThreadExecutor();

    //System.out.println(Arrays.stream(new int[]{}).max().getAsInt());
  }




  private class SkipNode {

    SkipNode left, right, up, down;
    String key;
    Integer value;
  }
}
