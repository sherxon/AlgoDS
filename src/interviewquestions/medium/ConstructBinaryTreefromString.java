package interviewquestions.medium;

import interviewquestions.utils.TreeNode;

import java.util.Stack;

/**
 * Created by sherxon on 3/11/17.
 */
public class ConstructBinaryTreefromString {
    public static void main(String[] args) {
        System.out.println(str2tree("4"));
    }

    static public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) return null;
        if (s.indexOf('(') == -1) {
            return new TreeNode(Integer.parseInt(s));
        }
        int r = Integer.parseInt(s.substring(0, s.indexOf('(', 0)));

        TreeNode root = new TreeNode(r);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        for (int i = 1; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                int left = s.indexOf(')', i + 1);
                int right = s.indexOf('(', i + 1);
                int min = 0;
                if (left == -1) min = right;
                else if (right == -1) min = left;
                else min = Math.min(left, right);

                r = Integer.parseInt(s.substring(i + 1, min));
                if (stack.peek().left == null) {
                    stack.peek().left = new TreeNode(r);
                    stack.push(stack.peek().left);
                } else {
                    stack.peek().right = new TreeNode(r);
                    stack.push(stack.peek().right);
                }
            } else if (c == ')') {
                stack.pop();
            }
        }
        return root;

    }
}
