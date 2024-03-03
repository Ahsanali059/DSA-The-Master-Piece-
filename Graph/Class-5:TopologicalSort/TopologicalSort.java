package Graph.Class

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

-5:TopologicalSort;

public class TopologicalSort 
{
    //Create Adjacency List and One stack 
    Map<Integer,List<Integer>> adjacencyList;

    private Stack<Integer> stack;


    public TopologicalSort()
    {
        this.adjacencyList = new HashMap()<>;
        this.stack = new Stack<>();
    }
    //add Vertex
    public void addVertex(int v)
    {
        adjacencyList.put(v,new ArrayList<>());

    }

    //add Edge Directed Graph 
    public void addEdge(int source,int destination)
    {
        adjacencyList.get(source).add(destination);
    }

    public void TopologicalSorting()
    {
        Set<Integer> visited = new HashSet<>();

        for(Integer v:adjacencyList.keySet())
        {
            if(!visited.contains(v))
            {
               dfs(vertex,visited);
            }
        }

        System.out.println("Topological Sort: ");
        while (!stack.isEmpty) 
        {
            System.out.println(stack.pop()+" ");
            
        }

        

    }

    private void dfs(int vertex,Set<Integer> visited)
    {
        visited.add(vertex);
        for(int neighbor:adjacencyList.get(vertex))
        {
            if(!visited.contains(neighbor))
            {
                dfs(vertex, visited);
            }
            
        }
        stack.push(vertex);
    } 

    public static void main(String[] args) 
    {
        //this can be apply only directed acyalic Graph 
        //what:Linear Ordering of vertices Such as that for every u->v 
        //u always Appears before v in that Ordering 

        //Example:0,1,2,3 --->Valid 
        //Example:3,2,1,0 --->Invalid 

        TopologicalSort ts = new TopologicalSort();


        for(int i=0;i<=4;i++)
        {
            ts.addVertex(i);
        }

        ts.addEdge(1, 2);
        ts.addEdge(3, 4);

        //print Graph 
        for(Map.Entry<Integer,List<Integer>> entry:ts.adjacencyList.entrySet())
        {
            
        }

        ts.TopologicalSorting();
        

        
        
    }
    
}
