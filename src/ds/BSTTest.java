package ds;

/**
 * Created by sherxon on 2016-12-16.
 */
public class BSTTest {
    public static void main(String[] args) {
        Tree<Integer> bst=new AVLTree<>();
        bst.insert(3);
        bst.insert(1);
        bst.insert(2);
        bst.insert(4);
        System.out.println(bst.search(2));
        String hello = new String("hello"); // in  pool and in heap, reference to heap
        String helloWorld = hello + " world"; // ref pool
        String ss="hello world";
        System.out.println(helloWorld == ss); //
        System.out.println(-3>>1);
        System.out.println(-4>>>1);
    }
}
