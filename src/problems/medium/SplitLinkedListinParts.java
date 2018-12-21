package problems.medium;

import problems.utils.ListNode;

/**
 * Why Did you create this class? what does it do?
 */
public class SplitLinkedListinParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        if (root == null)
            return new ListNode[k];
        if (k == 1)
            return new ListNode[] { root };
        int count = 0;
        ListNode temp = root;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int r = count % k;
        int n = count / k;
        ListNode[] a = new ListNode[k];
        if (n == 0) {
            for (int i = 0; i < r; i++) {
                a[i] = root;
                temp = root.next;
                root.next = null;
                root = temp;
            }

        } else {
            for (int i = 0; i < k; i++) {
                int j = 0;
                temp = root;
                while (j < n - 1) {
                    if (root != null)
                        root = root.next;
                    j++;
                }
                if (r > 0 && root != null) {
                    r--;
                    root = root.next;
                }
                a[i] = temp;
                if (root != null) {
                    temp = root.next;
                    root.next = null;
                }
                root = temp;
            }
        }

        return a;

    }
}
