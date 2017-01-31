package algo;

/**
 * Created by sherxon on 1/29/17.
 */
public class UnionFind {
    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind(10);
        unionFind.union(1, 3);
        unionFind.union(3, 5);
        unionFind.union(2, 4);
        unionFind.union(4, 6);
        unionFind.union(6, 9);
        System.out.println(unionFind.connected(2, 9));
        System.out.println(unionFind.connected(9, 4));
        System.out.println(unionFind.connected(1, 5));
        System.out.println(unionFind.connected(3, 4));
        unionFind.union(3, 6);
        System.out.println(unionFind.connected(5, 1));
        System.out.println(unionFind.connected(5, 9));
        System.out.println(unionFind.connected(1, 2));
        System.out.println(unionFind.connected(6, 10));
    }

    int[] a;

    public UnionFind(int size) {
        a = new int[size + 1];
        for (int i = 0; i < a.length; i++)
            a[i] = i;
    }

    public void union(int i, int j) {
        int ip = find(i);
        int jp = find(j);
        a[ip] = a[jp];
    }

    private int find(int i) {
        while (a[i] != i) i = a[i];
        return i;
    }

    public boolean connected(int i, int j) {
        return find(i) == find(j);
    }
}
