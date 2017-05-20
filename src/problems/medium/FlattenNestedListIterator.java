package problems.medium;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sherxon on 4/30/17.
 */
public class FlattenNestedListIterator {
    public class NestedIterator implements Iterator<Integer> {

        //List<NestedInteger> list;
        LinkedList<NestedInteger> list;
        public NestedIterator(List<NestedInteger> nestedList) {
            this.list= new LinkedList<>(nestedList);
        }

        @Override
        public Integer next() {
            return list.removeFirst().getInteger();
        }
        NestedInteger getFirstInteger(NestedInteger ni){
            if(ni==null || ni.isInteger())return ni;
            list.addAll(0, ni.getList());
            return getFirstInteger(list.pollFirst());
        }

        @Override
        public boolean hasNext() {
            if(list.isEmpty())return false;
            if(list.getFirst().isInteger())return true;
            NestedInteger n=getFirstInteger(list.pollFirst());
            if(n==null)return false;
            list.addFirst(n);
            return true;
        }
    }

}
