package adventofcode;

import java.util.*;

/**
 * Why Did you create this class? what does it do?
 */
@SuppressWarnings("Duplicates") public class Duet_18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();

        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s.equals("1"))
                break;
            builder.append(s).append("\n");
        }

        //System.out.println(s0lve(builder.toString()));
        Duet_18 duet = new Duet_18();
        System.out.println(duet.s0lve2(builder.toString()));

    }

    private static long s0lve(String s) {
        if (s == null || s.length() == 0l)
            return -1;
        String[] a = s.split("\n");
        Map<String, Long> map = new HashMap<>();
        long lastPlayed = 0;
        for (int i = 0; i < a.length; i++) {
            String current = a[i];
            String[] aa = current.split(" ");
            if (aa[0].equals("rcv")) {
                if (Character.isDigit(aa[1].charAt(0)) && Integer.parseInt(aa[1]) != 0) {
                    return lastPlayed;
                } else if (map.get(aa[1]) != 0) {
                    return lastPlayed;
                }
            } else if (aa[0].equals("snd")) {
                if (Character.isAlphabetic(aa[1].charAt(0))) {
                    lastPlayed = map.get(aa[2]);
                } else {
                    lastPlayed = Integer.parseInt(aa[1]);
                }
            } else if (aa[0].equals("set")) {
                if (Character.isAlphabetic(aa[2].charAt(0))) {
                    map.put(aa[1], map.getOrDefault(aa[2], 0l));
                } else {
                    map.put(aa[1], Long.parseLong(aa[2]));
                }
            } else if (aa[0].equals("add")) {
                if (Character.isAlphabetic(aa[2].charAt(0))) {
                    map.put(aa[1], map.get(aa[1]) + map.get(aa[2]));
                } else {
                    map.put(aa[1], map.get(aa[1]) + Long.parseLong(aa[2]));
                }
            } else if (aa[0].equals("mul")) {
                if (Character.isAlphabetic(aa[2].charAt(0))) {
                    map.put(aa[1], map.get(aa[1]) * map.get(aa[2]));
                } else {
                    map.put(aa[1], map.get(aa[1]) * Long.parseLong(aa[2]));
                }
            } else if (aa[0].equals("mod")) {
                if (Character.isAlphabetic(aa[2].charAt(0))) {
                    map.put(aa[1], map.get(aa[1]) % map.get(aa[2]));
                } else {
                    map.put(aa[1], map.get(aa[1]) % Long.parseLong(aa[2]));
                }
            } else if (aa[0].equals("jgz")) {
                if (map.get(aa[1]) <= 0L)
                    continue;
                if (Character.isAlphabetic(aa[2].charAt(0))) {
                    i += map.get(aa[2]);
                } else {
                    i += Integer.parseInt(aa[2]);
                }
                i -= 1;
            }
        }
        return 0;
    }

    int counter1 = 0;

    public long s0lve2(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        String[] a = s.split("\n");
        long[] map0 = new long[128];
        long[] map1 = new long[128];
        map0['p'] = 0;
        map1['p'] = 1;
        Queue<Long> queue0 = new LinkedList<>();
        Queue<Long> queue1 = new LinkedList<>();
        int p0 = 0;
        int p1 = 0;
        while (true) {

            p0 = helper(map0, queue0, queue1, p0, a, true);
            p1 = helper(map1, queue1, queue0, p1, a, false);

            if ((p0 == -1 && p1 == -1) || (queue0.size() == 0 && queue1.size() == 0)) {
                return counter1;
            }
        }
    }

    int helper(long[] map, Queue<Long> myQueue, Queue<Long> anotherQueue, int k, String[] a, boolean b) {
        for (int i = k; i < a.length; i++) {
            char index = a[i].charAt(4);
            if (a[i].startsWith("rcv")) {
                if (myQueue.isEmpty()) {
                    return i;
                }
                map[index] = myQueue.remove();
            } else if (a[i].startsWith("snd")) {
                anotherQueue.add(map[index]);
                if (!b) {
                    counter1++;
                }
            } else if (a[i].startsWith("set")) {
                if (Character.isAlphabetic(a[i].charAt(6))) {
                    map[index] = map[a[i].charAt(6)];
                } else {
                    map[index] = Long.parseLong(a[i].substring(6));
                }
            } else if (a[i].startsWith("add")) {
                if (Character.isAlphabetic(a[i].charAt(6))) {
                    map[index] += map[a[i].charAt(6)];
                } else {
                    map[index] += Long.parseLong(a[i].substring(6));
                }
            } else if (a[i].startsWith("mul")) {
                if (Character.isAlphabetic(a[i].charAt(6))) {
                    map[index] *= map[a[i].charAt(6)];
                } else {
                    map[index] *= Long.parseLong(a[i].substring(6));
                }
            } else if (a[i].startsWith("mod")) {
                if (Character.isAlphabetic(a[i].charAt(6))) {
                    map[index] %= map[a[i].charAt(6)];
                } else {
                    map[index] %= Long.parseLong(a[i].substring(6));
                }
            } else if (a[i].startsWith("jgz")) {
                if ((Character.isDigit(index) && index - '0' <= 0) ||
                    (Character.isAlphabetic(index) && map[index] <= 0)) {
                    continue;
                }
                if (Character.isAlphabetic(a[i].charAt(6))) {
                    i += map[a[i].charAt(6)];
                } else {
                    i += Integer.parseInt(a[i].substring(6));
                }
                i -= 1;
            }
        }
        return -1;
    }

}
