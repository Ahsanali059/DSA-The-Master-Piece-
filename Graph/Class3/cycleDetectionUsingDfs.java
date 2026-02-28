package Graph.Class3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class cycleDetectionUsingDfs 
{
     // Create Adjacency List
    Map<Integer, List<Integer>> adjacencyList;

    public cycleDetectionUsingDfs() {
        this.adjacencyList = new HashMap<>();
    }

    // Add vertex
    public void addVertex(int vertex) {
        adjacencyList.put(vertex, new ArrayList<>());
    }

    // Add Edge
    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    // Get neighbors
    public List<Integer> getNeighbors(int vertex) {
        return adjacencyList.get(vertex);
    }

    // Print Graph
    public void printGraph() {
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            int vertex = entry.getKey();
            // Store values
            List<Integer> neighbors = entry.getValue();

            System.out.print(vertex + ": ");

            for (int child : neighbors) {
                // Print
                System.out.print(child + " ");
            }
            System.out.println(); // Add a new line after printing neighbors of each vertex
        }
    }

    public boolean hasCycle()
    {
        Set<Integer> visited = new HashSet<>();

        for(Integer vertex : adjacencyList.keySet())
        {
            if(!visited.contains(vertex))
            {
                if(dfs(vertex,visited,-1))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int start,Set<Integer> visited,int parent)
    {
        visited.add(start);

        for(int neighbor:adjacencyList.get(start))
        {
            if(!visited.contains(neighbor))
            {
                if(dfs(neighbor, visited, start))
                {
                    return true;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) 
    {

        
    }
    
}
