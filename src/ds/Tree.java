package ds;

/**
 * Created by sherxon on 12/18/16.
 */
public interface Tree<K> {
    void insert(K k);
    boolean search(K k);
    void delete(K k);
}
