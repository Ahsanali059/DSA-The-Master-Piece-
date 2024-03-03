package Graph.Class7ShortestPath;

import java.util.*;

public class shortestPath {
    private int shortestPathLength = Integer.MAX_VALUE;

    public int findShortestPath(Map<Integer, List<Integer>> graph, int start, int end) {
        Set<Integer> visited = new HashSet<>();
        dfs(graph, start, end, 0, visited);
        if (shortestPathLength == Integer.MAX_VALUE) {
            return -1;
        } else {
            return shortestPathLength;
        }
    }

    public void dfs(Map<Integer, List<Integer>> graph, int start, int end, int pathLength, Set<Integer> visited) {
        if (start == end) {
            shortestPathLength = Math.min(shortestPathLength, pathLength);
            return;
        }

        visited.add(start);
        List<Integer> neighbors = graph.get(start);

        if (neighbors != null) {
            for (int n : neighbors) {
                if (!visited.contains(n)) {
                    dfs(graph, n, end, pathLength + 1, visited);
                }
            }
        }

        visited.remove(start);
    }

    public static void main(String[] args) {
        // Example graph representation
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(4));
        graph.put(3, Arrays.asList(4));
        graph.put(4, Arrays.asList());

        shortestPath shortestPathFinder = new shortestPath();

        // Finding the shortest path length from node 1 to node 4
        int shortestPathLength = shortestPathFinder.findShortestPath(graph, 1, 4);

        if (shortestPathLength != -1) {
            System.out.println("Shortest path length from 1 to 4: " + shortestPathLength);
        } else {
            System.out.println("No path found from 1 to 4");
        }
    }
}
