package problems.medium;

/**
 * Why Did you create this class? what does it do?
 */
public class RedundantConnection {
    public static void main(String[] args) {
        new RedundantConnection().findRedundantConnection(new int[][] {
                { 1, 2 },
                { 1, 3 },
                { 2, 3 }
        });
    }

    int[] a;
    int[] result;

    public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length == 0)
            return null;
        a = new int[edges.length + 1];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            connect(edges[i]);
        }

        return result;
    }

    void connect(int[] d) {
        int i = d[0];
        int j = d[1];
        int ii = find(i);
        int jj = find(j);
        if (ii == jj) {
            result = d;
        } else {
            a[ii] = jj;
        }
    }

    int find(int i) {
        while (a[i] != i)
            i = a[i];
        return i;
    }
}
