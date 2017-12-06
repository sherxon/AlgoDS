package adventofcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Why Did you create this class? what does it do?
 */
public class Interrupt_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            try {
                list.add(Integer.parseInt(scanner.nextLine()));
            } catch (Exception e) {
                break;
            }
        }
        System.out.println(solve2(list));
    }

    private static int solve(List<Integer> list) {
        int count = 0;
        int current = 0;
        while (current < list.size()) {
            int value = list.get(current);
            list.set(current, value + 1);
            current += value;
            count++;
        }

        return count;
    }

    private static int solve2(List<Integer> list) {
        int count = 0;
        int current = 0;
        while (current < list.size()) {
            int value = list.get(current);
            if (value >= 3) {
                list.set(current, value - 1);
            } else {
                list.set(current, value + 1);
            }
            current += value;
            count++;
        }

        return count;
    }
}
