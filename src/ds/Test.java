package ds;

/**
 * Created by sherxon on 5/25/17.
 */
public class Test {

  public static void main(String[] args) {
    HashedArrayTree hash = new HashedArrayTree();
    for (int i = 0; i < 500; i++) {
      hash.add(i);
      //hash.printStats();
      System.out.println(hash.get(i));
    }
  }

}
