package Graph.class8ShortextPathAcyclicGraph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class ShortextPathACyclicGraph 
{
private static final int INF = Integer.MAX_VALUE;

    public Map<Integer, Integer> shortestPath(Map<Integer, List<Node>> graph, int start) {
        Map<Integer, Integer> distance = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> topologicalOrder = new Stack<>();

        for (int vertex : graph.keySet()) {
            distance.put(vertex, INF);
        }

        for (int vertex : graph.keySet()) {
            if (!visited.contains(vertex)) {
                dfsTopologicalSort(graph, vertex, visited, topologicalOrder);
            }
        }

        distance.put(start, 0);

        while (!topologicalOrder.isEmpty()) {
            int current = topologicalOrder.pop();

            if (distance.get(current) != INF) {
                for (Node neighbor : graph.get(current)) {
                    int newDistance = distance.get(current) + neighbor.weight;
                    distance.put(neighbor.vertex, Math.min(distance.get(neighbor.vertex), newDistance));
                }
            }
        }

        return distance;
    }

    private void dfsTopologicalSort(Map<Integer, List<Node>> graph, int current, Set<Integer> visited, Stack<Integer> topOrder) {
        visited.add(current);

        for (Node neighbor : graph.get(current)) {
            if (!visited.contains(neighbor.vertex)) {
                dfsTopologicalSort(graph, neighbor.vertex, visited, topOrder);
            }
        }

        topOrder.push(current);
    }

    public static void main(String[] args) {
        // Example DAG representation
        Map<Integer, List<Node>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(new Node(2, 3), new Node(3, 1)));
        graph.put(2, Arrays.asList(new Node(4, 2)));
        graph.put(3, Arrays.asList(new Node(4, 1)));
        graph.put(4, Arrays.asList());

        ShortextPathACyclicGraph shortestPathFinder = new ShortextPathACyclicGraph();

        // Finding the shortest paths from source node 1
        Map<Integer, Integer> shortestPaths = shortestPathFinder.shortestPath(graph, 1);

        // Displaying the shortest paths
        for (int vertex : shortestPaths.keySet()) {
            System.out.println("Shortest path to vertex " + vertex + ": " + shortestPaths.get(vertex));
        }
    }
}

class Node {
    int vertex;
    int weight;

    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
    
    
}
