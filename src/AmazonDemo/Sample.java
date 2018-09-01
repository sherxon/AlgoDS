package AmazonDemo;

import java.util.*;

/**
 * Why Did you create this class? what does it do?
 */
public class Sample {

    List<List<Integer>> closestXdestinations(int numDestinations, List<List<Integer>> allLocations, int numDeliveries) {
        if (numDeliveries <= 0) {
            return new ArrayList<>();
        }
        if (numDestinations <= numDeliveries) {
            return allLocations;
        }
        return findNearestOnes(allLocations, numDeliveries);
    }

    /**
     * first calculates distances from starting point to all other
     * positions and returns nearest k positions.
     */
    private List<List<Integer>> findNearestOnes(List<List<Integer>> allLocations, int numDeliveries) {
        // start position of truck hardcoded here
        List<Integer> startPosition = new ArrayList<>();
        startPosition.add(0);
        startPosition.add(0);
        List<List<Integer>> result = new ArrayList<>();

        Map<Double, List<List<Integer>>> distances = new TreeMap<>();
        for (List<Integer> location : allLocations) {
            double distance = calculateDist(location, startPosition);
            List<List<Integer>> value = distances.getOrDefault(distance, new ArrayList<>());
            value.add(location);
            distances.put(distance, value);
        }
        for (Double key : distances.keySet()) {
            if (numDeliveries >= distances.get(key).size()) {
                result.addAll(distances.get(key));
                numDeliveries -= distances.get(key).size();
            } else {
                for (int i = 0; i < numDeliveries; i++) {
                    result.add(distances.get(key).get(i));
                }
                return result;
            }
            if (numDeliveries <= 0)
                return result;
        }

        return result;
    }

    /**
     * calculates distance between two points in plain
     * */
    private Double calculateDist(List<Integer> location, List<Integer> customer) {
        return Math.hypot(customer.get(0) - location.get(0), customer.get(1) - location.get(1));
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(1, 0, 0));
        lists.add(Arrays.asList(1, 0, 0));
        lists.add(Arrays.asList(1, 9, 1));
        System.out.println(new Sample().minimumDistance2(0, 0, lists));
    }

    int minimumDistance2(int numRows, int numColumns, List<List<Integer>> area) {
        if (area == null || area.size() == 0)
            return 0;
        int[] min = new int[] { Integer.MAX_VALUE };
        route(area, 0, 0, min, 0);
        return min[0] == Integer.MAX_VALUE ? -1 : min[0];
    }

    private void route(List<List<Integer>> area, int i, int j, int[] min, int distance) {
        if (i < 0 || j < 0 || i >= area.size() || j >= area.get(i).size())
            return;
        if (area.get(i).get(j) == 9) {
            min[0] = Math.min(min[0], distance);
            return;
        }
        if (area.get(i).get(j) <= 0)
            return;
        int val = area.get(i).get(j);
        area.get(i).set(j, -1);
        route(area, i + 1, j, min, distance + 1);
        route(area, i - 1, j, min, distance + 1);
        route(area, i, j + 1, min, distance + 1);
        route(area, i, j - 1, min, distance + 1);
        area.get(i).set(j, val);
    }

    int minimumDistance(int numRows, int numColumns, List<List<Integer>> area) {
        if (area == null || area.size() == 0)
            return 0;
        return bfs(area);
    }

    /**
     * Implementation of breadth first search. It terminates early in case target destination is found.
     *
     * @returns -1 if we cant reach to target point from start position.
     */
    private int bfs(List<List<Integer>> area) {
        boolean[][] visited = new boolean[area.size()][area.get(0).size()];
        int[][] distance = new int[area.size()][area.get(0).size()];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0)); // start position hardcoded
        visited[0][0] = true;
        while (!q.isEmpty()) {
            Pair current = q.remove();
            if (area.get(current.i).get(current.j) == 9) {// target found
                return distance[current.i][current.j];
            }
            List<Pair> neighbors = getNeighbors(current, area);
            for (Pair nei : neighbors) {
                if (!visited[nei.i][nei.j]) {
                    q.add(nei);
                    visited[nei.i][nei.j] = true;
                    distance[nei.i][nei.j] = distance[current.i][current.j] + 1; // increment distance
                }
            }
        }
        return -1;
    }

    /**
     * helper method to find neighbors
     *
     * @returns List of Pair available neighbor cells
     */
    private List<Pair> getNeighbors(Pair current, List<List<Integer>> area) {
        List<Pair> list = new ArrayList<>();
        int i = current.i;
        int j = current.j;
        int n = area.size();
        int m = area.get(0).size();
        if (j > 0 && area.get(i).get(j - 1) != 0) {
            list.add(new Pair(i, j - 1));
        }
        if (j < m - 1 && area.get(i).get(j + 1) != 0) {
            list.add(new Pair(i, j + 1));
        }
        if (i > 0 && area.get(i - 1).get(j) != 0) {
            list.add(new Pair(i - 1, j));
        }
        if (i < n - 1 && area.get(i + 1).get(j) != 0) {
            list.add(new Pair(i + 1, j));
        }
        return list;
    }

    /**
     * Helper data class to hold coordinates of locations
     */
    private class Pair {
        int i, j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
