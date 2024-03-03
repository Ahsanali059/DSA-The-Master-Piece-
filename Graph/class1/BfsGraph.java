import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BfsGraph 
{
    //step 1:Create Adjacency List 
    Map<Integer,List<Integer>> adjacencyList;

    public BfsGraph()
    {
        adjacencyList = new HashMap<>();
    }

    /*
     * add Vertex Method 
     * 
     */
    public void addVertex(int vertex)
    {
        adjacencyList.put(vertex, new ArrayList<>());
    }
    /*
     * add Edge
     * 
     */
    public void addEdge(int source,int destination)
    {
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }
    /*
     *
     * get neighbors 
     *
     */
    public List<Integer> getNeighbors(int vertex)
    {
        return adjacencyList.get(vertex);
    }

    /*
     * print graph
     * 
     */
    public void printGraph()
    {
        for(Map.Entry<Integer,List<Integer>> entry:adjacencyList.entrySet())
        {
            int vertex = entry.getKey();
            /*
             * get values
             */
            List<Integer> neighbors = entry.getValue();

            System.out.print(vertex + " ");

            for(int neighbor:neighbors)
            {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public void BFS(int vertex)
    {
        Set<Integer> visited = new HashSet<>();

        /*
         * for Maintain Vertex
         */
        Queue<Integer> queue = new LinkedList<>();

        /*
         * jab tk queue empty nahi ho jata item nikalta jaoi
         */
        while(!queue.isEmpty())
        {
            int curr = queue.poll();

            System.out.println("Current Vertex "+curr);

            /*
             * store vertex for the correspoinding neighbors
             */
            List<Integer> neighbors = adjacencyList.get(curr);

            for(int myNeighbor:neighbors)
            {
                if(!visited.add(myNeighbor))
                {
                    visited.add(myNeighbor);
                    queue.add(myNeighbor);
                }
            }
        }
    }



    public static void main(String[] args) 
    {
        BfsGraph g = new BfsGraph();

        // Adding vertices
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
    
        
        // Adding edges
        g.addEdge(1, 2);
        g.addEdge(2, 3);
    

        // Print the graph
        g.printGraph();
        
    }
    
}
