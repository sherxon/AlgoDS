package ds;

/**
 * Created by sherxon on 12/16/16.
 */
public class BSTTest {
    public static void main(String[] args) {
        Tree<Integer> bst=new AVLTree<>();
        bst.insert(3);
        bst.insert(1);
        bst.insert(2);
        bst.insert(4);
        System.out.println(bst.search(2));

    }
}
