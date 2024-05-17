import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import class3_CycleDetection.CycleDetectionBfs;



public class hasCycleUsingBfs 
{
    public boolean hasCycle(Map<Integer,List<Integer>> graph )
    {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> inProcess = new HashSet<>();


        for(int vertex:graph.keySet())
        {
            if(!visited.contains(vertex))
            {
                if (hasCycleUtil(graph, vertex, visited, inProcess)) {
                    return true;
                }
            }
        }

        return false;


    }

    private boolean hasCycleUtil(Map<Integer,List<Integer>> graph,int vertex,Set<Integer> visited,Set<Integer> inProcess)
    {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(vertex);
        visited.add(vertex);
        inProcess.add(vertex);

        while(!queue.isEmpty())
        {
            int currentVertex = queue.poll();
            inProcess.remove(currentVertex);


            List<Integer> neighbors = graph.get(currentVertex);

            if(neighbors!=null)
            {
                for(int n:neighbors)
                {
                    if(!visited.contains(n))
                    {
                        queue.offer(n);
                        visited.add(n);
                        inProcess.add(n);
                    }
                    else if(inProcess.contains(neighbors))
                    {
                        return true;
                    }
                }
            }
            
            
        }
        return false;
    }



    public static void main(String[] args) 
    {
       // Example graph representation with a cycle
       Map<Integer, List<Integer>> graphWithCycle = new HashMap<>();
       graphWithCycle.put(1, Arrays.asList(2));
       graphWithCycle.put(2, Arrays.asList(3));
       graphWithCycle.put(3, Arrays.asList(1));

       // Example graph representation without a cycle
       Map<Integer, List<Integer>> graphWithoutCycle = new HashMap<>();
       graphWithoutCycle.put(1, Arrays.asList(2, 3));
       graphWithoutCycle.put(2, Arrays.asList(4));
       graphWithoutCycle.put(3, Arrays.asList(4));
       graphWithoutCycle.put(4, Arrays.asList());
       hasCycleUsingBfs cycleUsingBfs = new hasCycleUsingBfs();

      
       
       // Testing with a graph containing a cycle
       boolean hasCycleWithCycle = cycleUsingBfs.hasCycle(graphWithCycle);
       System.out.println("Graph with cycle: " + hasCycleWithCycle);  // Output: true

       // Testing with a graph without a cycle
       boolean hasCycleWithoutCycle = cycleUsingBfs.hasCycle(graphWithoutCycle);
       System.out.println("Graph without cycle: " + hasCycleWithoutCycle);  // Output: false
        
    }
    
}
