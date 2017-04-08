package ds;

/**
 * Created by sherxon on 2016-12-18.
 */
public interface Tree<K> {
    void insert(K k);
    boolean search(K k);
    void delete(K k);
}
