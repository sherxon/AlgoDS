package AmazonDemo;

import java.util.*;

/**
 * Why Did you create this class? what does it do?
 */
public class Sample {

    List<List<Integer>> nearestXsteakHouses(int totalSteakhouses, List<List<Integer>> allLocations, int numSteakhouses) {
        if (numSteakhouses <= 0) {
            return new ArrayList<>();
        }
        if (totalSteakhouses <= numSteakhouses) {
            return allLocations;
        }
        List<List<Integer>> result = new ArrayList<>();
        dijkstra(allLocations, numSteakhouses, result);
        return result;
    }

    private void dijkstra(List<List<Integer>> allLocations, int numSteakhouses, List<List<Integer>> result) {
        int x = 0;
        int y = 0;
        List<Integer> customer = new ArrayList<>();
        customer.add(x);
        customer.add(y);
        Map<Double, List<List<Integer>>> dis = new TreeMap<>();
        for (List<Integer> location : allLocations) {
            double distance = calculateDist(location, customer);
            List<List<Integer>> value = dis.getOrDefault(distance, new ArrayList<>());
            value.add(location);
            dis.put(distance, value);
        }
        for (Double key : dis.keySet()) {
            if (numSteakhouses >= dis.get(key).size()) {
                result.addAll(dis.get(key));
                numSteakhouses -= dis.get(key).size();
            } else {
                for (int i = 0; i < numSteakhouses; i++) {
                    result.add(dis.get(key).get(i));
                }
                return;
            }
            if (numSteakhouses <= 0)
                return;
        }

    }

    private Double calculateDist(List<Integer> location, List<Integer> customer) {
        return Math.hypot(customer.get(0) - location.get(0), customer.get(1) - location.get(1));
    }

    int minimumDistance(int numRows, int numColumns, List<List<Integer>> area) {
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
        if (area.get(i).get(j) == 0)
            return;
        if (area.get(i).get(j) == -1)
            return;

        int val = area.get(i).get(j);
        route(area, i + 1, j, min, distance + 1);
        route(area, i - 1, j, min, distance + 1);
        route(area, i, j + 1, min, distance + 1);
        route(area, i, j - 1, min, distance + 1);
        area.get(i).set(j, val);
    }
}
