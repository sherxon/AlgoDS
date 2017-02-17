package interviewquestions.medium;

import interviewquestions.utils.TreeNode;

/**
 * Created by sherxon on 2/15/17.
 */
public class ConstructBTFromPreOrderAndInorder {
    public static void main(String[] args) {
        TreeNode treeNode = new ConstructBTFromPreOrderAndInorder().buildTree(
                new int[]{7, 10, 4, 3, 1, 2, 8, 11},
                new int[]{4, 10, 3, 1, 7, 11, 8, 2}
//                new int[]{1,2,3},
//                new int[]{2,1,3}
        );
        System.out.println(treeNode);
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        return build(preorder, 0, inorder, 0, inorder.length - 1);
    }

    TreeNode build(int[] pre, int preStart, int[] in, int inStart, int inEnd) {
        if (preStart >= pre.length || inStart > inEnd) return null;

        TreeNode root = new TreeNode(pre[preStart]);

        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == root.val) {
                index = i;
                break;
            }
        }

        root.left = build(pre, preStart + 1, in, inStart, index - 1);
        root.right = build(pre, preStart + index - inStart + 1, in, index + 1, inEnd);

        return root;
    }
}
