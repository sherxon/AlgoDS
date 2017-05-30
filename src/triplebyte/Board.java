package triplebyte;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

/**
 * Created by sherxon on 5/17/17.
 */
public class Board {

    static char[][] a = new char[3][3];
    CountDownLatch countDownLatch = new CountDownLatch(10);

    public static void main(String[] args) {
        clear();
        Scanner in = new Scanner(System.in);
        AI ai = new AI(a);
        while (!isFull()) {
            int i = in.nextInt();
            int j = in.nextInt();
            if (i > 2 || i < 0 || j < 0 || j > 2) {
                System.out.println("Please enter valid input");
                continue;
            }
            if (a[i][j] != '-') {
                System.out.println("the spot is already taken sorry ((");
                continue;
            }

            a[i][j] = 'X';

            if (isFull()) {
                break;
            }
            ai.move();
            print();
        }
    }

    private static void clear() {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = '-';
            }
        }
    }

    private static void read(char token, int i, int j) {
        if (a[i][j] != '0')
            a[i][j] = token;
        else
            System.out.println("taken");
    }

    private static void print() {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (j != a.length - 1)
                    System.out.print(a[i][j] + "|");
                else
                    System.out.print(a[i][j]);

            }
            System.out.println();
        }
    }


    public static boolean isFull() {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] != '-') return true;
            }
        }

        return false;
    }

    private static class AI {
        char[][] a;

        public AI(char[][] a) {
            this.a = a;
        }

        void move() {
            if (!checkMove())
                throw new IllegalStateException("AI, you are wrong ");
        }

        int[] makeMove() {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {
                    if (a[i][j] == '-') return new int[]{i, j};
                }
            }
            return new int[]{0, 0};
        }

        boolean checkMove() {
            int[] index = makeMove();
            if (a[index[0]][index[1]] != '-') return false;

            a[index[0]][index[1]] = '0';

            return true;
        }
    }
}
