import java.util.*;

public class TopologicalSortUsingBfs {

    public void topologicalSort(Map<Integer, List<Integer>> graph) {
        Map<Integer, Integer> inDegrees = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        // Step 1: Calculate in-degrees for each vertex
        for (int vertex : graph.keySet()) {
            inDegrees.put(vertex, 0);
        }

        for (List<Integer> neighbors : graph.values()) {
            for (int neighbor : neighbors) {
                inDegrees.put(neighbor, inDegrees.get(neighbor) + 1);
            }
        }

        // Step 2: Enqueue vertices with in-degree 0
        for (int vertex : inDegrees.keySet()) {
            if (inDegrees.get(vertex) == 0) {
                queue.offer(vertex);
            }
        }

        // Step 3: Perform BFS
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            List<Integer> neighbors = graph.get(currentVertex);
            if (neighbors != null) {
                for (int neighbor : neighbors) {
                    inDegrees.put(neighbor, inDegrees.get(neighbor) - 1);
                    if (inDegrees.get(neighbor) == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // Example graph representation (you can replace it with your own graph)
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(4));
        graph.put(3, Arrays.asList(4));
        graph.put(4, Arrays.asList());

        TopologicalSortUsingBfs topologicalSorter = new TopologicalSortUsingBfs();
        topologicalSorter.topologicalSort(graph);
    }
}
