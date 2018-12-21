package adventofcode;

import java.util.Scanner;
import java.util.Stack;

/**
 * Why Did you create this class? what does it do?
 */
@SuppressWarnings("Duplicates") public class StreamProcessing_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s.equals("1"))
                break;
            builder.append(s);
        }
        System.out.println(solve2(builder));
    }

    private static int solve(StringBuilder builder) {
        if (builder == null || builder.length() == 0)
            return 0;
        // clean ignore garbage
        StringBuilder s = new StringBuilder();
        boolean ignore = false;
        for (int i = 0; i < builder.length(); i++) {
            char current = builder.charAt(i);
            if (ignore) {
                ignore = false;
                continue;
            }
            if (current == '!') {
                ignore = true;
                continue;
            }
            s.append(current);
        }
        // clean garbage
        int i = 0;
        while (i < s.length()) {
            int start = s.indexOf("<");
            if (start < 0)
                break;
            int end = s.indexOf(">", start);
            if (end < 0)
                throw new IllegalArgumentException("wrong input");
            s.delete(start, end + 1);
            i = end + 1;
        }
        Stack<Character> stack = new Stack<>();
        int sum = 0;
        for (int j = 0; j < s.length(); j++) {
            char current = s.charAt(j);
            if (current == ',')
                continue;
            if (current == '{') {
                stack.add(current);
            } else {
                sum += stack.size();
                stack.pop();
            }
        }

        return sum;
    }

    private static int solve2(StringBuilder builder) {
        if (builder == null || builder.length() == 0)
            return 0;
        // clean ignore garbage
        StringBuilder s = new StringBuilder();
        boolean ignore = false;
        for (int i = 0; i < builder.length(); i++) {
            char current = builder.charAt(i);
            if (ignore) {
                ignore = false;
                continue;
            }
            if (current == '!') {
                ignore = true;
                continue;
            }
            s.append(current);
        }
        // clean garbage
        int i = 0;
        int sum = 0;
        while (i < s.length()) {
            int start = s.indexOf("<");
            if (start < 0)
                break;
            int end = s.indexOf(">", start);
            if (end < 0)
                throw new IllegalArgumentException("wrong input");
            s.delete(start, end + 1);
            sum += (end - start - 1);
            i = end + 1;
        }

        return sum;
    }
}
