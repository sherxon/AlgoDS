package adventofcode;

import java.util.*;

/**
 * Why Did you create this class? what does it do?
 */
public class MemoryReallocation_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext()) {
            try {
                int i = Integer.parseInt(scanner.next());
                list.add(i);
            } catch (Exception e) {
                break;
            }

        }
        System.out.println(solve2(list));
    }

    private static int solve(List<Integer> list) {
        int count = 0;
        Set<String> set = new HashSet<>();
        String s = list.toString();
        System.out.println(s);
        while (set.add(s)) {
            int max = -1;
            int maxi = -1;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > max) {
                    max = list.get(i);
                    maxi = i;
                }
            }
            list.set(maxi, 0);
            maxi++;
            maxi %= list.size();
            while (max > 0) {
                list.set(maxi, list.get(maxi) + 1);
                maxi++;
                maxi %= list.size();
                max--;
            }
            count++;
            s = list.toString();
            System.out.println(s);

        }

        return count;
    }

    private static int solve2(List<Integer> list) {
        int count = 0;
        Map<String, Integer> map = new HashMap<>();
        String s = list.toString();
        System.out.println(s);
        while (!map.containsKey(s)) {
            map.put(s, count);
            int max = -1;
            int maxi = -1;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > max) {
                    max = list.get(i);
                    maxi = i;
                }
            }
            list.set(maxi, 0);
            maxi++;
            maxi %= list.size();
            while (max > 0) {
                list.set(maxi, list.get(maxi) + 1);
                maxi++;
                maxi %= list.size();
                max--;
            }
            count++;
            s = list.toString();
            System.out.println(s + " " + count);
        }
        System.out.println(s + " " + count);

        return count - map.get(s);
    }
}
