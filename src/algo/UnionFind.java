package algo;

/**
 * Created by sherxon on 1/29/17.
 */
public class UnionFind {
    int[] a;
    int[] sz;
    public UnionFind(int size) {
        a = new int[size + 1];
        sz = new int[size + 1];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
            sz[i] = 1;
        }

    }

    public void union(int i, int j) {
        int ip = find(i);
        int jp = find(j);
        if (sz[ip] < sz[jp]) {
            a[ip] = jp;
            sz[jp] += sz[ip];
        } else {
            sz[ip] += sz[jp];
            a[jp] = a[ip];
        }

    }

    private int find(int i) {
        while (a[i] != i) {
            a[i] = a[a[i]];
            i = a[i];

        }
        return i;
    }

    public boolean connected(int i, int j) {
        return find(i) == find(j);
    }
}
