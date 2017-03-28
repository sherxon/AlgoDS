package interviewquestions.easy;

/**
 * Created by sherxon on 3/28/17.
 */

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

public class QueuewithMinimum {
    PrintWriter out;
    Queue<Long> queue = new LinkedList<>();
    LinkedList<Long> mins = new LinkedList<>();

    private void pop() {
        long last = queue.poll();
        if (mins.peek().compareTo(last) == 0) mins.poll();
    }

    private void min() {
        out.println(mins.peek());
    }

    private void push(long i) {
        queue.add(i);
        if (mins.isEmpty() || mins.peekLast().compareTo(i) <= 0)
            mins.add(i);
        else {
            while (!mins.isEmpty() && mins.peekLast().compareTo(i) > 0) {
                mins.removeLast();
            }
            mins.add(i);
        }
    }
}
