package class3_CycleDetection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CycleDetectionBfs 
{
    //step 1:
    //Create Adjacency List 
    Map<Integer,List<Integer>> adjacenyList;


    public CycleDetectionBfs()
    { 
        this.adjacenyList = new HashMap<>();

    }

    //add vertex
    public void addVertex(int vertex)
    {
        adjacenyList.put(vertex, new ArrayList<>());
    }
    //add Edge

    public void addEdge(int source,int destination)
    {
       adjacenyList.get(source).add(destination);
       adjacenyList.get(destination).add(source);

    }
    //get neighbors
    public List<Integer> getNeighbors(int vertex)
    {
       return adjacenyList.get(vertex);

    }

    //print Graph 
    //print Graph 
    public void printGraph() {
    for (Map.Entry<Integer, List<Integer>> entry : adjacenyList.entrySet()) {
        int vertex = entry.getKey();
        //store values
        List<Integer> neighbors = entry.getValue();

        System.out.print(vertex + ": ");

        for (int child : neighbors) {
            //print
            System.out.print(child + " ");
        }
        System.out.println(); // Add a new line after printing neighbors of each vertex
    }
}


    public boolean hasCycle()
    {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        for(Integer vertex:adjacenyList.keySet())
        {
             if(!visited.add(vertex))
             {
                if(bfs(vertex,visited,queue))
                {
                    return true;
                }
             }
        }
        return false;

    }

    public boolean bfs(int start,Set<Integer> visited,Queue<Integer> queue)
    {
        Map<Integer,Integer> parent = new HashMap<>();

        queue.add(start);
        visited.add(start);
        parent.put(start,null);

        while(!queue.isEmpty())
        {
            int Currentvertex = queue.poll();

            for(int neighbor:adjacenyList.get(Currentvertex))
            {
                if(!visited.contains(neighbor))
                {
                    visited.add(neighbor);
                    queue.add(neighbor);
                    parent.put(neighbor, Currentvertex);
                }
                else if(parent.get(Currentvertex)!=neighbor)
                {
                    return true;
                }
            }
        }
        return false;


    }



    public static void main(String[] args) 
    {
       CycleDetectionBfs graph = new CycleDetectionBfs();

     

       // Adding vertices
       for (int i = 1; i <= 4; i++) {
           graph.addVertex(i);
       }

       // Adding edges to create a cycle
       graph.addEdge(1, 2);
       graph.addEdge(2, 3);
       graph.addEdge(3, 1);

       // Print the graph
       graph.hasCycle();  // Should print "Cycle detected"
        
    }
    
}
