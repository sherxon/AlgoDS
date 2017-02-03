package interviewquestions.medium;

/**
 * Created by sherxon on 2/1/17.
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation


interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {


    LinkedList<NestedInteger> ll = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {

        ll.addAll(nestedList.stream().collect(Collectors.toList()));
    }

    @Override
    public Integer next() {
        return ll.removeFirst().getInteger();
    }

    @Override
    public boolean hasNext() {
        if (ll.isEmpty()) return false;
        if (ll.getFirst().isInteger()) return true;

        NestedInteger ni = ll.removeFirst();
        LinkedList<NestedInteger> temp = new LinkedList<>();
        ni.getList().forEach(temp::addFirst);
        temp.forEach(ll::addFirst);
        return hasNext();
    }
}
