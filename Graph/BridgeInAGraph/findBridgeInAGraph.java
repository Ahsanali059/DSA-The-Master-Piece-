package Graph.BridgeInAGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * What Is a Bridge? First of all, bridges, also known as cut edges, are specific types of edges in a graph. A bridge is a connection between two nodes that, if removed, causes the network to become unconnected and thus increases the number of linked nodes.
 * 
 * Example:two Graph connected with Each Other using one single edge 
 */

class Edge
{
    String source;
    String destination;
    int weight;

    public Edge(String source,String destination,int weight)
    {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}


class Graph
{
    //create adjacency List 
    Map<String,List<Edge>> adjacencyList =new HashMap<>();

    public void addEdge(String source,String destination,int weight)
    {
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.put(destination, new ArrayList<>());

        //add edge 
        adjacencyList.get(source).add(new Edge(source, destination, weight));
        adjacencyList.get(destination).add(new Edge(destination,source,weight));
    }
    public List<Edge> getNeigborList(String node)
    {
        return adjacencyList.get(node);
    }

    public Set<String> getNodes()
    {
        return adjacencyList.keySet();
    }

    /*
     * method to find bridge
     * 
     */
    public void findBridge()
    {
        //The discovery time of a vertex is the time when the vertex is first visited during the DFS traversal.
        //It helps to establish the order in which vertices are visited, which is essential for identifying the structure of the DFS tree. 
        Map<String,Integer> discovery = new HashMap<>();
        
        //low is the low of the time that is neighbor time 
        Map<String,Integer> low = new HashMap<>();

        //map to store the parent of the Node 
        Map<String, String> parent = new HashMap<>();
        Set<String> visited = new HashSet<>();

        //Initalize everything 
        for(String node:getNodes())
        {
            discovery.put(node, -1);
            low.put(node, -1);
            parent.put(node, null);
        }

        //which time you reaching a Node (steps) that is insertion 
        int []time = {0};

        for(String node:getNodes())
        {
            if(!visited.contains(node))
            {
                findBridgesUtil(node,visited,discovery,low,parent,time);
            }
        }  
    }

    private void findBridgesUtil(String node, Set<String> visited, Map<String, Integer> discovery,
    Map<String, Integer> low, Map<String, String> parent, int[] time) 
    {

        visited.add(node);
        discovery.put(node, time[0]);
        low.put(node, time[0]);
        time[0] += 1;

        Graph graph = new Graph();

        //use the bfs approach to find the bridge 
        for(Edge edge:graph.getNeigborList(node))
        {
            String v = edge.destination;

            if(!visited.contains(v))
            {
                //store the parent of Node 

                parent.put(v, node);

                findBridgesUtil(node, visited, discovery, low, parent, time);


                low.put(node, Math.min(low.get(node), low.get(v)));

                //if new low is graeter then prevois Low there is a Bridge 
                if (low.get(v) > discovery.get(node)) {
                    System.out.println(node + " -- " + v + " is a bridge");
                }
            } 
            else if (!v.equals(parent.get(node))) {
                //If v is already visited and is not the parent of node, update the low value of node.
                low.put(node, Math.min(low.get(node), discovery.get(v)));
            }


        }

    
    
    
    }
}

public class findBridgeInAGraph 
{
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge("1", "0", 1);
        g.addEdge("0", "2", 1);
        g.addEdge("2", "1", 1);
        g.addEdge("0", "3", 1);
        g.addEdge("3", "4", 1);

        System.out.println("Bridges in the graph:");
        g.findBridge();
    }

    
}
