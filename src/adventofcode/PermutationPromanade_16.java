package adventofcode;

import java.util.*;

/**
 http://adventofcode.com/2017/day/16
 */
@SuppressWarnings("Duplicates")
public class PermutationPromanade_16 {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s.equals("1"))
                break;
            builder.append(s);
        }
        System.out.println(solve2(builder.toString()));
    }

    private static String solve(String s) {
        if (s == null || s.length() == 0)
            return s;
        String[] input = s.split(",");
        int[] a = new int[16];
        for (int i = 0; i < a.length; i++)
            a[i] = i;

        for (int i = 0; i < input.length; i++) {
            String current = input[i];
            if (current.endsWith(","))
                current = current.substring(0, current.length() - 1);
            if (current.startsWith("s")) {
                int n = Integer.parseInt(current.substring(1, current.length()));
                int[] temp = new int[a.length];
                int k = a.length - n;
                for (int j = 0; j < a.length; j++) {
                    temp[j] = a[(j + k) % a.length];
                }
                a = temp;
            } else if (current.startsWith("x")) {
                String[] split = current.substring(1, current.length()).split("/");
                int ff = Integer.parseInt(split[0]);
                int ss = Integer.parseInt(split[1]);
                int temp = a[ff];
                a[ff] = a[ss];
                a[ss] = temp;
            } else {
                String[] split = current.substring(1, current.length()).split("/");
                int ff = split[0].charAt(0) - 'a';
                int ss = split[1].charAt(0) - 'a';
                int fi = 0, si = 0;
                for (int j = 0; j < a.length; j++) {
                    if (a[j] == ff)
                        fi = j;
                    if (a[j] == ss)
                        si = j;
                }
                int temp = a[fi];
                a[fi] = a[si];
                a[si] = temp;
            }
        }
        StringBuilder builder = new StringBuilder();
        Arrays.stream(a).map(e -> ((char) (e + 'a'))).forEach(e -> builder.append((char) e));
        return builder.toString();
    }

    private static String solve2(String s) {
        if (s == null || s.length() == 0)
            return s;
        String[] input = s.split(",");
        int[] a = new int[16];
        for (int i = 0; i < a.length; i++)
            a[i] = i;
        for (int m = 0; m < 40; m++) {
            for (int i = 0; i < input.length; i++) {
                String current = input[i];
                if (current.endsWith(","))
                    current = current.substring(0, current.length() - 1);
                if (current.startsWith("s")) {
                    int n = Integer.parseInt(current.substring(1, current.length()));
                    int[] temp = new int[a.length];
                    int k = a.length - n;
                    for (int j = 0; j < a.length; j++) {
                        temp[j] = a[(j + k) % a.length];
                    }
                    a = temp;
                } else if (current.startsWith("x")) {
                    String[] split = current.substring(1, current.length()).split("/");
                    int ff = Integer.parseInt(split[0]);
                    int ss = Integer.parseInt(split[1]);
                    int temp = a[ff];
                    a[ff] = a[ss];
                    a[ss] = temp;
                } else {
                    String[] split = current.substring(1, current.length()).split("/");
                    int ff = split[0].charAt(0) - 'a';
                    int ss = split[1].charAt(0) - 'a';
                    int fi = 0, si = 0;
                    for (int j = 0; j < a.length; j++) {
                        if (a[j] == ff)
                            fi = j;
                        if (a[j] == ss)
                            si = j;
                    }
                    int temp = a[fi];
                    a[fi] = a[si];
                    a[si] = temp;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        Arrays.stream(a).map(e -> ((char) (e + 'a'))).forEach(e -> builder.append((char) e));
        return builder.toString();
    }
}
