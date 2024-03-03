package Graph.class4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CycleDetectionUsing 
{
     // Create Adjacency List
    Map<Integer, List<Integer>> adjacencyList;

    public CycleDetectionUsing() {
        this.adjacencyList = new HashMap<>();
    }

    // Add vertex
    public void addVertex(int vertex) {
        adjacencyList.put(vertex, new ArrayList<>());
    }

    // Add Edge
    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
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

            System.out.print(vertex + " -> ");

            for (int child : neighbors) {
                // Print
                System.out.print(child + " ");
            }
            System.out.println(); // Add a new line after printing neighbors of each vertex
        }
    } 

    public boolean isCycle()
    {
       Set<Integer> visited = new HashSet<>();
       Set<Integer> recursiveStack = new HashSet<>();

       for(Integer v:adjacencyList.keySet())
       {
          if(!visited.contains(v))
          {
            if(dfs(v,visited,recursiveStack))
            {
                return true;
            }
          }
       }
       return false;

    }

    public boolean dfs(int currentVertex, Set<Integer> visited, Set<Integer> recursionStack) {
        visited.add(currentVertex);
        recursionStack.add(currentVertex);

        for (int neighbor : adjacencyList.get(currentVertex)) {
            if (!visited.contains(neighbor)) {
                if (dfs(neighbor, visited, recursionStack)) {
                    return true; // Cycle detected
                }
            } else if (recursionStack.contains(neighbor)) {
                return true; // Cycle detected
            }
        }

        recursionStack.remove(currentVertex);
        return false;
    }



    public static void main(String[] args) 
    {
        CycleDetectionUsing graph = new CycleDetectionUsing();

        for(int i=0;i<=4;i++)
        {
            graph.addVertex(i);
        }

         // Adding edges to create a cycle
         graph.addEdge(1, 2);
         graph.addEdge(2, 3);
         graph.addEdge(3, 1);
 
         // Print the graph
         graph.printGraph();
 
         // Check for cycle
         if (graph.isCycle()) {
             System.out.println("Cycle detected");
         } else {
             System.out.println("No cycle found");
         }


        
    }
    
}
