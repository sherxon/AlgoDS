package google;

import java.util.*;

/**
 * Why Did you create this class? what does it do?
 */
@SuppressWarnings("Duplicates")
public class EscapePods {
    public static void main(String[] args) {
        System.out.println(answer(new int[] { 0, 1 }, new int[] { 4, 5 }, new int[][] {
                { 0, 0, 4, 6, 0, 0 },
                { 0, 0, 5, 2, 0, 0 },
                { 0, 0, 0, 0, 4, 4 },
                { 0, 0, 0, 0, 6, 6 },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 }
        }));
        System.out.println(answer(new int[] { 0 }, new int[] { 3 }, new int[][] {
                { 0, 7, 0, 0 },
                { 0, 0, 6, 0 },
                { 0, 0, 0, 8 },
                { 9, 0, 0, 0 },
                }));
    }

    public static int answer(int[] entrances, int[] exits, int[][] path) {
        if (entrances == null || entrances.length == 0 || exits == null || exits.length == 0)
            return 0;
        if (path == null || path.length == 0)
            return 0;
        int res = 0;
        int[] rooms = new int[50];
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> setE = new HashSet<>();
        for (int i = 0; i < entrances.length; i++) {
            rooms[entrances[i]] = -1;
            q.add(entrances[i]);
            setE.add(entrances[i]);
        }
        for (int exit : exits) {
            setE.add(exit);
        }

        while (!q.isEmpty()) {
            int room = q.remove();
            setE.remove(room);
            int[] nei = path[room];
            for (int i = 0; i < nei.length; i++) {
                if (nei[i] == 0)
                    continue;
                int val = nei[i];
                if (rooms[room] != -1) {
                    val = Math.min(val, rooms[room]);
                    rooms[room] -= val;
                }
                rooms[i] += val;
                if (setE.add(i)) {
                    q.add(i);
                }
            }
        }

        for (int i = 0; i < exits.length; i++) {
            res += rooms[exits[i]];
        }

        return res;
    }

}
