package ds;

/**
 * Created by sherxon on 12/16/16.
 */
public class BSTTest {
    public static void main(String[] args) {
        BST<Integer> bst=new BST<>();
        bst.insert(4);
        bst.insert(3);
        bst.insert(3);
        bst.insert(7);
        bst.insert(5);
        bst.insert(6);
        bst.insert(8);
        System.out.println(bst.search(7));
        System.out.println(bst.search(1));
        System.out.println(bst.search(2));
    }
}
