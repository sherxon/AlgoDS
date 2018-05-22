package AmazonDemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Why Did you create this class? what does it do?
 */
public class Demo1 {
    public static void main(String[] args) {
        System.out.println(cellCompete(new int[] {
                1, 0, 0, 0, 0, 1, 0, 0
        }, 1));
        System.out.println(cellCompete(new int[] {
                1, 1, 1, 0, 1, 1, 1, 1
        }, 2));

    }

    static public List<Integer> cellCompete(int[] states, int days) {
        // WRITE YOUR CODE HERE
        if (days <= 0) {
            return Arrays.stream(states).boxed().collect(Collectors.toList());
        }
        int prev = 0;
        for (int i = 0; i < days; i++) {
            for (int j = 0; j < states.length; j++) {
                int tempPrev = states[j];
                if (j == 0) {
                    states[j] = states[1] == 0 ? 0 : 1;
                } else if (j == states.length - 1) {
                    states[j] = prev == 0 ? 0 : 1;
                } else {
                    states[j] = prev == states[j + 1] ? 0 : 1;
                }
                prev = tempPrev;
            }
        }
        return Arrays.stream(states).boxed().collect(Collectors.toList());

    }
}
