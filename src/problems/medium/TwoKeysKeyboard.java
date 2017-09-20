package problems.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Why Did you create this class? what does it do?
 */
public class TwoKeysKeyboard {
    public static void main(String[] args) {
        System.out.println(new TwoKeysKeyboard().minSteps(522));
    }
    public int minSteps(int n) {
        if(n<=1)return 0;

        Queue<Node> q= new LinkedList<>();
        q.add(new Node(2, 1, 2));
        Map<Integer, Integer> map= new HashMap<>();
        while(!q.isEmpty()){
            Node current=q.remove();
            if(current.val==n)return current.step;
            int left=current.val+current.copyVal;
            int right=current.val*2;
            if(left<n && map.put(left, current.copyVal)==null);
                q.add(new Node(left, current.copyVal, current.step+1));
            if(right<n && map.put(right, current.val)==null)
                q.add(new Node(right, current.val, current.step+2));
        }
        return -1;
    }
    private class Node{
        int val;
        int copyVal;
        int step;
        Node(int v, int c, int s){
            val=v;
            copyVal=c;
            step=s;
        }

        @Override public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            Node node = (Node) o;

            if (val != node.val)
                return false;
            return copyVal == node.copyVal;
        }

        @Override public int hashCode() {
            int result = val;
            result = 31 * result + copyVal;
            return result;
        }
    }
}
