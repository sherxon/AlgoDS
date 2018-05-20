package problems.hard;

/**
 * Why Did you create this class? what does it do?
 */
public class SimilarStringGroups {

    public int numSimilarGroups(String[] a) {
        if (a == null || a.length == 0)
            return 0;
        int count = a.length;
        Union un = new Union(count);
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (compare(a[i], a[j]) && un.connect(i, j))
                    count--;
            }
        }
        return count;
    }

    boolean compare(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                count++;
            if (count > 2)
                return false;
        }
        return count == 2;
    }

    class Union {
        int[] a;

        Union(int size) {
            a = new int[size];
            for (int i = 0; i < size; i++) {
                a[i] = i;
            }
        }

        boolean connect(int i, int j) {
            int ii = find(i);
            int jj = find(j);
            if (ii == jj)
                return false;
            a[ii] = jj;
            return true;
        }

        int find(int i) {
            while (a[i] != i)
                i = a[i];
            return i;
        }

    }
}
