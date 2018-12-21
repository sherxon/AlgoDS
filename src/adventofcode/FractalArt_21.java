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
        if (s == null || s.length() == 0) {
            return 0;
        }
        String[] a = s.split("\n");
        Map<String, String> rules = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            rules.put(a[i].split(" => ")[0].trim(), a[i].split("=>")[1].trim());
        }
        // default state of matrix given by problem statement
        List<List<Character>> image = new ArrayList<>();
        image.add(Arrays.asList('.', '#', '.'));
        image.add(Arrays.asList('.', '.', '#'));
        image.add(Arrays.asList('#', '#', '#'));
        for (int i = 0; i < 18; i++) {
            System.out.println(i);
            List<List<Character>> newImage = new ArrayList<>();
            if (image.size() % 2 == 0) {

                for (int j = 0; j < image.size() - 1; j += 2) {//rows

                    newImage.add(new ArrayList<>());
                    newImage.add(new ArrayList<>());
                    newImage.add(new ArrayList<>());

                    List<Character> current = image.get(j);

                    for (int k = 0; k < current.size() - 1; k += 2) {
                        String square = current.get(k) + "" + current.get(k + 1) + "/" + image.get(j + 1).get(k) + "" + image.get(j + 1).get(k + 1);

                        List<List<Character>> match = findMatch(square, rules);

                        for (int l = 0; l < match.size(); l++) {
                            int index = j == 0 ? 0 : j / 2 * 3;
                            newImage.get(index + l).addAll(match.get(l));
                        }
                    }
                }
            } else if (image.size() % 3 == 0) {
                for (int j = 0; j < image.size() - 2; j += 3) {
                    List<Character> current = image.get(j);

                    newImage.add(new ArrayList<>());
                    newImage.add(new ArrayList<>());
                    newImage.add(new ArrayList<>());
                    newImage.add(new ArrayList<>());

                    for (int k = 0; k < current.size() - 2; k += 3) {

                        String square = current.get(k) + "" + current.get(k + 1) + current.get(k + 2) + "/"
                                        + image.get(j + 1).get(k) + "" + image.get(j + 1).get(k + 1) + image.get(j + 1).get(k + 2) + "/"
                                        + image.get(j + 2).get(k) + "" + image.get(j + 2).get(k + 1) + image.get(j + 2).get(k + 2);

                        List<List<Character>> match = findMatch(square, rules);

                        for (int l = 0; l < match.size(); l++) {
                            int index = j == 0 ? 0 : j / 3 * 4;
                            newImage.get(index + l).addAll(match.get(l));
                        }

                    }
                }
            }
            image = newImage;
        }
        int counter = 0;
        for (int i = 0; i < image.size(); i++) {
            for (int j = 0; j < image.get(i).size(); j++) {
                if (image.get(i).get(j) == '#')
                    counter++;
            }
        }
        return counter;
    }

    private static List<List<Character>> findMatch(String p, Map<String, String> rules) {
        String result = null;
        if (!rules.containsKey(p)) {
            String[] a = p.split("/");
            for (String key : rules.keySet()) {
                if (equals(key, a, false)) {
                    result = rules.get(key);
                }
            }
        } else {
            result = rules.get(p);
        }

        List<List<Character>> list = new ArrayList<>();
        String[] ar = result.split("/");
        for (int i = 0; i < ar.length; i++) {
            List<Character> ll = new ArrayList<>();
            for (int j = 0; j < ar[i].length(); j++) {
                ll.add(ar[i].charAt(j));
            }
            list.add(ll);
        }
        return list;
    }

    private static boolean equals(String key, String[] a, boolean print) {
        String[] b = key.split("/");
        if (b.length != a.length)
            return false;
        char[][] squareMatrix = getMatrix(a);
        char[][] ruleMatrix = getMatrix(b);
        char[][] reversedRuleMatrix = flip(ruleMatrix);

        for (int i = 0; i < 4; i++) {
            boolean found = true;
            for (int j = 0; j < squareMatrix.length; j++) {
                if (j >= squareMatrix.length || j >= ruleMatrix.length) {
                    System.out.println("hah");
                }
                if (!Arrays.equals(squareMatrix[j], ruleMatrix[j])) {
                    found = false;
                }
            }
            if (found)
                return true;

            found = true;
            for (int j = 0; j < squareMatrix.length; j++) {
                if (!Arrays.equals(squareMatrix[j], reversedRuleMatrix[j])) {
                    found = false;
                }
            }
            if (found)
                return true;

            rotate(ruleMatrix);
            rotate(reversedRuleMatrix);
        }

        return false;

    }

    private static void rotate(char[][] a) {
        int n = a.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                char temp = a[i][j];
                a[i][j] = a[n - j - 1][i];
                a[n - j - 1][i] = a[n - i - 1][n - j - 1];
                a[n - i - 1][n - j - 1] = a[j][n - i - 1];
                a[j][n - i - 1] = temp;
            }
        }
    }

    private static char[][] flip(char[][] bm) {
        char[][] a = new char[bm.length][bm.length];
        for (int i = 0; i < bm.length; i++) {
            for (int j = 0; j < bm.length; j++) {
                a[i][j] = bm[i][j];
            }
        }
        for (int i = 0; i < bm.length; i++) {
            reverseM(a[i]);
        }
        return a;
    }

    private static void reverseM(char[] a) {
        int i = 0;
        int j = a.length - 1;
        while (i < j) {
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }

    private static char[][] getMatrix(String[] b) {
        char[][] bm = new char[b[0].length()][b[0].length()];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b.length; j++) {
                bm[i][j] = b[i].charAt(j);
            }
        }
        return bm;
    }
}
