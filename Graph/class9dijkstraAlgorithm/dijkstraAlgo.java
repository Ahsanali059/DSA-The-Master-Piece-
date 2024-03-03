package Graph.class9dijkstraAlgorithm;

import java.util.Arrays;

public class dijkstraAlgo 
{
    public static final int INF = Integer.MAX_VALUE;

    public static void dijkstraAlgorithm(int [][] graph,int start)
    {
        //step 1:create require data structure
        int vertices = graph.length;

        int []distance = new int[vertices];

        boolean[] visited = new boolean[vertices];

        //step 2:intailize the distance array with max value
        Arrays.fill(distance, INF);

        //step 3:Intailze start node with 0
        distance[start] = 0;

        // step 4:Iterate whole graph and find minimum distance
        for(int i=0;i<vertices-1;i++)
        {
            //step 5:Parent vertex nikal lo 
            int minVertex = findMinimumDistanceVertex(distance,visited);

            visited[minVertex] = true;

            //step 6:us ka child ko iterate karo ure distance compare karo wo zero nahi hona chaiya 
            for(int j=0;j<vertices;j++)
            {
                if (!visited[j] && graph[minVertex][j] != 0 && distance[minVertex] != INF &&
                distance[minVertex] + graph[minVertex][j] < distance[j]) 
                {

                    //update distance 
                    distance[j] = distance[minVertex] + graph[minVertex][j];
                          
                }
            }
        }

        printSolution(distance);

    }

    public static int findMinimumDistanceVertex(int []distance,boolean[]visited)
    {
        int minDistance = INF;
        int minVertex = -1;

        for(int i=0;i<distance.length;i++)
        {
            if(!visited[i] &&distance[i]<minDistance)
            {
                //update distance and i value for next vertex
                minDistance = distance[i];
                minVertex = i;

            }

        }

        return minVertex;


    }

    private static void printSolution(int[] distances) {
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < distances.length; i++) {
            System.out.println(i + " \t\t " + distances[i]);
        }
    }

    public static void main(String[] args) 
    {
        int[][] graph = {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
    };

    dijkstraAlgo algo = new dijkstraAlgo();


    algo.dijkstraAlgorithm(graph, 0);
        
    }
    
}
