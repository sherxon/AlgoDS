package contests;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by sherxon on 1/28/17.
 */
public class Maze2 {

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        Map<Integer, Map<String, String>> map = new TreeMap<>();
        find(maze, map, ball[0], ball[1], hole, "", "");
        System.out.println(map);
        Integer key = map.keySet().iterator().next();
        Map<String, String> mm = map.get(key);
        for (String s : mm.keySet()) {
            if (!mm.get(s).contains("1")) return s;
        }
        return "impossible";
    }

    private void find(int[][] maze, Map<Integer, Map<String, String>> set, int i, int j, int[] hole, String s, String path) {
        if (i < 0 || i >= maze.length || j < 0 || j >= maze[i].length || maze[i][j] == 2) return;
        if (i == hole[0] && j == hole[1]) {
            if (!set.containsKey(path.length()))
                set.put(path.length(), new TreeMap<>());
            set.get(path.length()).put(s, path);
            return;
        }
        int temp = maze[i][j];
        path += maze[i][j];
        maze[i][j] = 2;

        find(maze, set, i + 1, j, hole, s.length() > 0 && s.charAt(s.length() - 1) == 'd' ? s : s + "d", path);
        find(maze, set, i - 1, j, hole, s.length() > 0 && s.charAt(s.length() - 1) == 'u' ? s : s + "u", path);
        find(maze, set, i, j + 1, hole, s.length() > 0 && s.charAt(s.length() - 1) == 'r' ? s : s + "r", path);
        find(maze, set, i, j - 1, hole, s.length() > 0 && s.charAt(s.length() - 1) == 'l' ? s : s + "l", path);
        maze[i][j] = temp;
    }


}
