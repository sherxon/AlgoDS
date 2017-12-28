package adventofcode;

import java.util.*;

/**
 * Why Did you create this class? what does it do?
 */
@SuppressWarnings("Duplicates")
public class FractalArt_21 {
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
        System.out.println(solve(builder.toString()));
    }

    private static int solve(String s) {
        if (s == null || s.length() == 0)
            return 0;
        String[] a = s.split("\n");
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            map.put(a[i].split(" => ")[0].trim(), a[i].split("=>")[1].trim());
        }
        List<List<Character>> list = new ArrayList<>();
        list.add(Arrays.asList('.', '#', '.'));
        list.add(Arrays.asList('.', '.', '#'));
        list.add(Arrays.asList('#', '#', '#'));
        for (int i = 0; i < 18; i++) {
            List<List<Character>> nList = new ArrayList<>();
            if (list.size() % 2 == 0) {

                for (int j = 0; j < list.size() - 1; j += 2) {//rows

                    nList.add(new ArrayList<>());
                    nList.add(new ArrayList<>());
                    nList.add(new ArrayList<>());

                    List<Character> cur = list.get(j);

                    for (int k = 0; k < cur.size() - 1; k += 2) {
                        String p = cur.get(k) + "" + cur.get(k + 1) + "/" + list.get(j + 1).get(k) + "" + list.get(j + 1).get(k + 1);

                        List<List<Character>> match = findMatch(p, map);

                        for (int l = 0; l < match.size(); l++) {
                            int index = j == 0 ? 0 : j / 2 * 3;
                            nList.get(index + l).addAll(match.get(l));
                        }
                    }
                }
            } else if (list.size() % 3 == 0) {
                for (int j = 0; j < list.size() - 2; j += 3) {
                    List<Character> cur = list.get(j);

                    nList.add(new ArrayList<>());
                    nList.add(new ArrayList<>());
                    nList.add(new ArrayList<>());
                    nList.add(new ArrayList<>());

                    for (int k = 0; k < cur.size() - 2; k += 3) {

                        String p = cur.get(k) + "" + cur.get(k + 1) + cur.get(k + 2) + "/"
                                   + list.get(j + 1).get(k) + "" + list.get(j + 1).get(k + 1) + list.get(j + 1).get(k + 2) + "/"
                                   + list.get(j + 2).get(k) + "" + list.get(j + 2).get(k + 1) + list.get(j + 2).get(k + 2);

                        List<List<Character>> match = findMatch(p, map);

                        for (int l = 0; l < match.size(); l++) {
                            int index = j == 0 ? 0 : j / 3 * 4;
                            nList.get(index + l).addAll(match.get(l));
                        }

                    }
                }
            }
            list = nList;
        }
        int counter = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                if (list.get(i).get(j) == '#')
                    counter++;
            }
        }
        return counter;
    }

    private static void printt(List<List<Character>> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private static List<List<Character>> findMatch(String p, Map<String, String> map) {
        String res = null;
        if (!map.containsKey(p)) {
            String[] a = p.split("/");
            for (String key : map.keySet()) {
                if (equals(key, a)) {
                    res = map.get(key);
                }
            }
        } else {
            res = map.get(p);
        }
        List<List<Character>> list = new ArrayList<>();
        String[] ar = res.split("/");
        for (int i = 0; i < ar.length; i++) {
            List<Character> ll = new ArrayList<>();
            for (int j = 0; j < ar[i].length(); j++) {
                ll.add(ar[i].charAt(j));
            }
            list.add(ll);
        }
        return list;
    }

    private static boolean equals(String key, String[] a) {
        String[] b = key.split("/");
        String[] b2 = new StringBuilder(key).reverse().toString().split("/");
        for (int i = 0; i < a.length; i++) {
            boolean yes = false;
            for (int j = 0; j < b.length; j++) {
                if (a[i].equals(b[j]) || a[i].equals(b2[j])) {
                    yes = true;
                    break;
                }
            }
            if (!yes) {
                return false;
            }
        }
        return true;

    }
}
