package adventofcode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * http://adventofcode.com/2017/day/13
 */

@SuppressWarnings("Duplicates")
public class PacketScanners_13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();

            if (s.equals("1"))
                break;

            if (s.length() > 0)
                builder.append(s).append("\n");
        }
        System.out.println(solve2(builder.toString()));
    }

    private static int solve(String s) {
        if (s == null || s.length() == 0)
            return 0;
        String[] a = s.split("\n");
        int sum = 0;
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            int level = Integer.parseInt(a[i].split(": ")[0]);
            int depth = Integer.parseInt(a[i].split(": ")[1]);
            map.put(level, depth);
            max = Math.max(level, max);
        }
        for (int i = 1; i <= max; i++) {
            if (map.containsKey(i)) {
                int k = i / (map.get(i) - 1);
                int r = i % (map.get(i) - 1);
                if (r == 0 && k % 2 == 0) {
                    sum += i * map.get(i);
                }
            }
        }
        return sum;
    }

    private static int solve2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        String[] a = s.split("\n");
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            int level = Integer.parseInt(a[i].split(": ")[0]);
            int depth = Integer.parseInt(a[i].split(": ")[1]);
            map.put(level, depth);
            max = Math.max(level, max);
        }
        int delay = 1;
        while (true) {

            boolean caught = false;

            for (int i = 0; i <= max; i++) {
                if (map.containsKey(i)) {

                    int k = (i + delay) / (map.get(i) - 1);
                    int r = (i + delay) % (map.get(i) - 1);

                    if (r == 0 && k % 2 == 0) {
                        caught = true;
                        break;
                    }
                }
            }
            if (!caught)
                break;
            delay++;
        }

        return delay;
    }

}
