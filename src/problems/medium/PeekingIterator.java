package problems.medium;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by sherxon on 1/6/17.
 */
public class PeekingIterator implements Iterator<Integer> {


    Iterator<Integer> iterator;
    LinkedList<Integer> list;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator=iterator;
        list=new LinkedList<>();
        while (iterator.hasNext()){
            list.add(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
       return list.getFirst();
    }


    @Override
    public boolean hasNext() {
        return list.iterator().hasNext();
    }

    @Override
    public Integer next() {
        return list.removeFirst();
    }
}
