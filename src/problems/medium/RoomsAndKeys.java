package problems.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Why Did you create this class? what does it do?
 */
public class RoomsAndKeys {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() <= 1)
            return true;
        Set<Integer> set = new HashSet<>();
        go(rooms, set, 0);
        return set.size() == rooms.size();
    }

    void go(List<List<Integer>> rooms, Set<Integer> set, int i) {
        if (set.contains(i))
            return;
        set.add(i);
        for (Integer key : rooms.get(i)) {
            if (!set.contains(key))
                go(rooms, set, key);
        }
    }
}
