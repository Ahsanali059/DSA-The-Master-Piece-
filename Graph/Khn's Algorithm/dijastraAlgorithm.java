import java.util.*;

/**
 * what is: Dijkstra's algorithm is a famous algorithm used for finding the shortest paths between nodes in a graph, which may represent, for example, road networks
 * The algorithm was conceived by Dutch computer scientist Edsger W. Dijkstra in 1956 and published in 1959.
 */

//step 1:
class Edge
{
    String destination;
    int weight;


    public Edge(String destination,int weight)
    {
        this.destination = destination;
        this.weight = weight;

    }
}

//Graph
class Graph1
{
    //Create adjacency List
    Map<String,List<Edge>> adjacencyList = new HashMap<>();

    public void addEdge(String source,String destination,int weight)
    {
        adjacencyList.putIfAbsent(source,new ArrayList<>());
        adjacencyList.putIfAbsent(destination,new ArrayList<>());

        //add edge
        adjacencyList.get(source).add(new Edge(destination,weight));
        adjacencyList.get(destination).add(new Edge(source,weight));
    }


    //get Neighbors
    public List<Edge> getNeighbors(String node)
    {
        return adjacencyList.get(node);

    }

    //get Node

    public Set<String> getNodes()
    {
        return adjacencyList.keySet();
    }
}

/**
 * step 3
 */
class Dijkstra
{
    public Map<String,Integer> shortestPath(Graph1 graph,String startNode)
    {
        Set<String> nodes = graph.getNodes();

        //create Map that store the distance

        Map<String ,Integer> distance = new HashMap<>();

        PriorityQueue<String> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(distance::get));

        //Create map can store the prevois weight

        Map<String,Integer> prevoius = new HashMap<>();

        /**
         * if node and start node is equal then store distance is 0
         */


        for(String node:nodes)
        {
            if(nodes.equals(startNode))
            {
                distance.put(node, 0);
            }
            else {
                distance.put(node,Integer.MAX_VALUE);
            }

            priorityQueue.add(node);

        }

        while(!priorityQueue.isEmpty())
        {
            String currentNode = priorityQueue.poll();

            List<Edge> neighbors = graph.getNeighbors(currentNode);

            if(neighbors!=null)
            {
                for (Edge neighbor:neighbors)
                {
                    int newDistance = distance.get(currentNode) + neighbor.weight;

                    if(newDistance < distance.get(neighbor.destination))
                    {
                        //if less then mark this is shortest path
                        distance.put(neighbor.destination,newDistance);
                        prevoius.put(neighbor.destination, Integer.valueOf(currentNode));

                        priorityQueue.remove(neighbor.destination);
                        priorityQueue.add(neighbor.destination);
                    }
                }
            }



        }
        return distance;


    }


    public static void main(String[] args)
    {
        Graph1 graph = new Graph1();
        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 2);
        graph.addEdge("B", "C", 5);
        graph.addEdge("B", "D", 10);
        graph.addEdge("C", "D", 3);

        Dijkstra calculator = new Dijkstra();

        Map<String,Integer> shortestDistances = calculator.shortestPath(graph, "A");

        System.out.println("Shortest distances from node A:");
        for (Map.Entry<String, Integer> entry : shortestDistances.entrySet()) {
            System.out.println("To node " + entry.getKey() + ": " + entry.getValue());
        }


    }
}


