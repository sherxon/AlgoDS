package problems.hard;

import java.util.*;

public class FreqStack {
    PriorityQueue<Pair> q;
    Map<Integer, Pair> map;
    int index = -1;

    public FreqStack() {
        q = new PriorityQueue<>();
        map = new HashMap<>();
    }

    public void push(int x) {
        index++;
        Pair pair = map.getOrDefault(x, new Pair(x));
        pair.add(index);
        map.put(x, pair);
        q.remove(pair);
        q.add(pair);
    }

    public int pop() {
        Pair pair = q.remove();
        pair.decrement();
        if (pair.count <= 0) {
            map.remove(pair.val);
        } else {
            q.add(pair);
        }
        return pair.val;
    }

    class Pair implements Comparable<Pair> {
        int val;
        int count;
        List<Integer> list = new ArrayList<>();

        public Pair(int val) {
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            Pair pair = (Pair) o;
            return val == pair.val;
        }

        void add(int index) {
            count++;
            list.add(index);
        }

        void decrement() {
            count--;
            list.remove(list.size() - 1);
        }

        @Override
        public int hashCode() {
            return val;
        }

        @Override
        public int compareTo(Pair o) {
            if (count > o.count)
                return -1;
            if (count < o.count)
                return 1;
            return o.list.get(o.list.size() - 1) - list.get(list.size() - 1);
        }
    }

}

