package problems.medium;

import java.util.*;

/**
 * Simple graph traversal problem
 */
public class EmployeeImportance {
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    int total = 0;

    public int getImportance(List<Employee> employees, int id) {

        if (employees == null || employees.isEmpty())
            return 0;

        if (employees.size() == 1)
            return employees.get(0).importance;
        Set<Integer> visited = new HashSet<>();
        visited.add(id);
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        total = map.get(id).importance;
        dfs(id, visited, map);
        return total;
    }

    void dfs(int start, Set<Integer> visited, Map<Integer, Employee> map) {
        for (Integer sub : map.get(start).subordinates) {
            if (!visited.contains(sub)) {
                total += map.get(sub).importance;
                visited.add(sub);
                dfs(sub, visited, map);
            }
        }
    }
}
