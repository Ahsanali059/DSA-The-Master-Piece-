package Graph.BridgeInAGraph;

import java.util.*;

/**
 * this approach is Know as Trajan's algorithm 
 */
class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // Initialize the graph as an adjacency list
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // Build the graph
        for (List<Integer> connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);
            graph[u].add(v);
            graph[v].add(u);
        }

        // Initialize necessary data structures
        int[] discovery = new int[n];
        int[] low = new int[n];
        int[] parent = new int[n];
        Arrays.fill(discovery, -1); // Discovery time of each vertex (initially -1)
        Arrays.fill(low, -1); // Lowest discovery time reachable from the subtree
        Arrays.fill(parent, -1); // Parent vertices in DFS tree

        List<List<Integer>> result = new ArrayList<>();
        int[] time = {0}; // Current time during DFS

        // DFS from each vertex
        for (int i = 0; i < n; i++) {
            if (discovery[i] == -1) {
                dfs(i, graph, discovery, low, parent, time, result);
            }
        }

        return result;
    }

    private void dfs(int u, List<Integer>[] graph, int[] discovery, int[] low, int[] parent, int[] time, List<List<Integer>> result) {
        discovery[u] = low[u] = time[0]++;
        
        for (int v : graph[u]) {
            if (discovery[v] == -1) { // If v is not visited
                parent[v] = u;
                dfs(v, graph, discovery, low, parent, time, result);

                // Check if the subtree rooted at v has a connection back to one of the ancestors of u
                low[u] = Math.min(low[u], low[v]);

                // If the lowest vertex reachable from subtree under v is below u in DFS tree, then u-v is a bridge
                if (low[v] > discovery[u]) {
                    result.add(Arrays.asList(u, v));
                }
            } else if (v != parent[u]) { // Update low value of u for parent function calls
                low[u] = Math.min(low[u], discovery[v]);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 5;
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(1, 0));
        connections.add(Arrays.asList(0, 2));
        connections.add(Arrays.asList(2, 1));
        connections.add(Arrays.asList(0, 3));
        connections.add(Arrays.asList(3, 4));

        List<List<Integer>> result = sol.criticalConnections(n, connections);
        for (List<Integer> edge : result) {
            System.out.println(edge);
        }
    }
}
