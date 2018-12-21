package adventofcode;

import java.util.*;

/**
 * Why Did you create this class? what does it do?
 */
@SuppressWarnings("Duplicates")
public class SporificaVirus_22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();

        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s.trim().length() == 0) {
                break;
            }
            builder.append(s).append("\n");
        }
        System.out.println(solve2(builder.toString()));
    }

    private static int solve(String s) {
        if (s == null || s.length() == 0)
            return 0;
        String[] ar = s.split("\n");
        int counter = 0;
        int x = ar.length / 2;
        int y = ar[0].length() / 2;
        Map<Integer, Set<Integer>> infected = new HashMap<>();

        for (int i = 0; i < ar.length; i++) {
            infected.put(i, new HashSet<>());
            for (int j = 0; j < ar[i].length(); j++) {
                if (ar[i].charAt(j) == '#') {
                    infected.get(i).add(j);
                }
            }
        }
        int direction = 1; // 1 up, -1 down, 2 right, -2 left
        for (int i = 0; i < 10_000; i++) {

            boolean isInfected = infected.containsKey(x) && infected.get(x).contains(y);

            if (isInfected) {
                if (direction == 1) {
                    direction = 2;
                } else if (direction == 2) {
                    direction = -1;
                } else if (direction == -1) {
                    direction = -2;
                } else {
                    direction = 1;
                }
            } else {
                if (direction == 1) {
                    direction = -2;
                } else if (direction == -2) {
                    direction = -1;
                } else if (direction == -1) {
                    direction = 2;
                } else {
                    direction = 1;
                }
            }

            if (!isInfected) {
                if (!infected.containsKey(x))
                    infected.put(x, new HashSet<>());

                if (infected.get(x).add(y))
                    counter++;
            } else {
                infected.get(x).remove(y);
            }

            if (Math.abs(direction) == 1) {
                x += -direction;
            } else {
                y += (direction > 0 ? 1 : -1);
            }
        }

        return counter;
    }

    private static int solve2(String s) {
        if (s == null || s.length() == 0)
            return 0;
        String[] ar = s.split("\n");
        int counter = 0;
        int x = ar.length / 2;
        int y = ar[0].length() / 2;
        Map<Integer, Map<Integer, Character>> map = new HashMap<>();

        for (int i = 0; i < ar.length; i++) {
            map.put(i, new HashMap<>());
            for (int j = 0; j < ar[i].length(); j++) {
                if (ar[i].charAt(j) == '#') {
                    map.get(i).put(j, 'i');
                } else {
                    map.get(i).put(j, 'c');
                }
            }
        }
        int direction = 1; // 1 up, -1 down, 2 right, -2 left
        for (int i = 0; i < 10_000_000; i++) {

            char state = !map.containsKey(x) || !map.get(x).containsKey(y) ? 'c' : map.get(x).get(y);

            if (state == 'i') {
                if (direction == 1) {
                    direction = 2;
                } else if (direction == 2) {
                    direction = -1;
                } else if (direction == -1) {
                    direction = -2;
                } else {
                    direction = 1;
                }
            } else if (state == 'c') {
                if (direction == 1) {
                    direction = -2;
                } else if (direction == -2) {
                    direction = -1;
                } else if (direction == -1) {
                    direction = 2;
                } else {
                    direction = 1;
                }
            } else if (state == 'f') {
                direction *= -1;
            }

            if (!map.containsKey(x))
                map.put(x, new HashMap<>());

            if (state == 'c') {
                map.get(x).put(y, 'w');
            } else if (state == 'w') {
                counter++;
                map.get(x).put(y, 'i');
            } else if (state == 'i') {
                map.get(x).put(y, 'f');
            } else {
                map.get(x).put(y, 'c');
            }

            if (Math.abs(direction) == 1) {
                x += -direction;
            } else {
                y += (direction > 0 ? 1 : -1);
            }
        }

        return counter;
    }
}
