package ds;

/**
 * Created by sherxon on 12/16/16.
 */
public class BSTTest {
    public static void main(String[] args) {
        BST<Integer> bst=new BST<>();
        bst.insert(5);
        bst.insert(3);
        bst.insert(1);
        bst.insert(2);
        bst.insert(4);
        bst.insert(11);
        bst.insert(7);
        bst.insert(6);
        bst.insert(9);
        bst.insert(8);
        bst.insert(10);
        bst.insert(15);
        bst.insert(12);
        bst.insert(14);
        bst.insert(13);
        System.out.println(bst.search(11));
        bst.delete(11);
        System.out.println(bst.search(11));
        System.out.println(bst.search(12));
        System.out.println(bst.search(13));


    }
}
