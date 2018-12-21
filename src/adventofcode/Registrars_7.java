package adventofcode;

import java.util.*;

/**
 * Why Did you create this class? what does it do?
 */
@SuppressWarnings("Duplicates") public class Registrars_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s.equals("1")) {
                break;
            }
            list.add(s);
        }
        System.out.println(solve2(list));

    }

    private static int solve(List<String> list) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            String[] a = s.split(" ");

            if (!map.containsKey(a[0]))
                map.put(a[0], 0);

            if (!map.containsKey(a[4]))
                map.put(a[4], 0);

            if (a[5].equals(">") && map.get(a[4]) > Integer.parseInt(a[6])) {
                if (a[1].equals("inc"))
                    map.put(a[0], map.get(a[0]) + Integer.parseInt(a[2]));
                else
                    map.put(a[0], map.get(a[0]) - Integer.parseInt(a[2]));
            } else if (a[5].equals("<") && map.get(a[4]) < Integer.parseInt(a[6])) {
                if (a[1].equals("inc"))
                    map.put(a[0], map.get(a[0]) + Integer.parseInt(a[2]));
                else
                    map.put(a[0], map.get(a[0]) - Integer.parseInt(a[2]));
            } else if (a[5].equals(">=") && map.get(a[4]) >= Integer.parseInt(a[6])) {
                if (a[1].equals("inc"))
                    map.put(a[0], map.get(a[0]) + Integer.parseInt(a[2]));
                else
                    map.put(a[0], map.get(a[0]) - Integer.parseInt(a[2]));
            } else if (a[5].equals("<=") && map.get(a[4]) <= Integer.parseInt(a[6])) {
                if (a[1].equals("inc"))
                    map.put(a[0], map.get(a[0]) + Integer.parseInt(a[2]));
                else
                    map.put(a[0], map.get(a[0]) - Integer.parseInt(a[2]));
            } else if (a[5].equals("==") && map.get(a[4]) == Integer.parseInt(a[6])) {
                if (a[1].equals("inc"))
                    map.put(a[0], map.get(a[0]) + Integer.parseInt(a[2]));
                else
                    map.put(a[0], map.get(a[0]) - Integer.parseInt(a[2]));
            } else if (a[5].equals("!=") && map.get(a[4]) != Integer.parseInt(a[6])) {
                if (a[1].equals("inc"))
                    map.put(a[0], map.get(a[0]) + Integer.parseInt(a[2]));
                else
                    map.put(a[0], map.get(a[0]) - Integer.parseInt(a[2]));
            }

        }
        int max = 0;
        for (String s1 : map.keySet()) {
            max = Math.max(max, map.get(s1));
        }

        return max;
    }

    private static int solve2(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        int max = 0;

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            String[] a = s.split(" ");

            if (!map.containsKey(a[0]))
                map.put(a[0], 0);

            if (!map.containsKey(a[4]))
                map.put(a[4], 0);

            if (a[5].equals(">") && map.get(a[4]) > Integer.parseInt(a[6])) {
                if (a[1].equals("inc"))
                    map.put(a[0], map.get(a[0]) + Integer.parseInt(a[2]));
                else
                    map.put(a[0], map.get(a[0]) - Integer.parseInt(a[2]));
            } else if (a[5].equals("<") && map.get(a[4]) < Integer.parseInt(a[6])) {
                if (a[1].equals("inc"))
                    map.put(a[0], map.get(a[0]) + Integer.parseInt(a[2]));
                else
                    map.put(a[0], map.get(a[0]) - Integer.parseInt(a[2]));
            } else if (a[5].equals(">=") && map.get(a[4]) >= Integer.parseInt(a[6])) {
                if (a[1].equals("inc"))
                    map.put(a[0], map.get(a[0]) + Integer.parseInt(a[2]));
                else
                    map.put(a[0], map.get(a[0]) - Integer.parseInt(a[2]));
            } else if (a[5].equals("<=") && map.get(a[4]) <= Integer.parseInt(a[6])) {
                if (a[1].equals("inc"))
                    map.put(a[0], map.get(a[0]) + Integer.parseInt(a[2]));
                else
                    map.put(a[0], map.get(a[0]) - Integer.parseInt(a[2]));
            } else if (a[5].equals("==") && map.get(a[4]) == Integer.parseInt(a[6])) {
                if (a[1].equals("inc"))
                    map.put(a[0], map.get(a[0]) + Integer.parseInt(a[2]));
                else
                    map.put(a[0], map.get(a[0]) - Integer.parseInt(a[2]));
            } else if (a[5].equals("!=") && map.get(a[4]) != Integer.parseInt(a[6])) {
                if (a[1].equals("inc"))
                    map.put(a[0], map.get(a[0]) + Integer.parseInt(a[2]));
                else
                    map.put(a[0], map.get(a[0]) - Integer.parseInt(a[2]));
            }
            max = Math.max(max, map.get(a[0]));
        }

        return max;
    }
}
