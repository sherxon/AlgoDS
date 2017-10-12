package problems.medium;

/**
 * Why Did you create this class? what does it do?
 */
public class NextClosestTime {
    public static void main(String[] args) {
        System.out.println(new NextClosestTime().nextClosestTime("19:34"));
    }

    public String nextClosestTime(String time) {
        int n = Integer.parseInt(time.split(":")[0] + time.split(":")[1]);
        for (int i = n / 100; i < 24; i++) {
            int k = n % 100 + 1;
            if (i > n / 100)
                k = 0;
            for (int j = k; j < 60; j++) {
                if (contains(time, i, j)) {
                    return make(i, j);
                }
            }
        }
        for (int i = 0; i < n / 100; i++) {
            for (int j = 0; j < n % 100; j++) {
                if (contains(time, i, j)) {
                    return make(i, j);
                }
            }
        }
        return time;

    }

    String make(int i, int j) {
        String l = i < 10 ? "0" + i : i + "";
        String r = j < 10 ? "0" + j : j + "";
        return l + ":" + r;

    }

    boolean contains(String s, int i, int j) {
        if ((i < 10 || j < 10) && !s.contains("0"))
            return false;
        while (i != 0) {
            if (!s.contains(i % 10 + ""))
                return false;
            i /= 10;
        }

        while (j != 0) {
            if (!s.contains(j % 10 + ""))
                return false;
            j /= 10;
        }

        return true;
    }
}
