package Graph.bellmenFordAlgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * The Bellman-Ford algorithm is another popular algorithm used for finding the shortest paths between nodes in a weighted graph. It works on both positive and negative edge weights, unlike Dijkstra's algorithm, which requires non-negative edge weights.
 * ->Dijastra relax nodes only one time 
 * 
 * You have to relax every edge v-1 number of time if vertex is 3 then 3-1=2 time relax 
 * -> then it find the negative edge cycle if change then negative edge cycle if 
 * not change then there is not negative edge cycle 
 */

//step 1:Create Edge class 
import java.util.*;

// Step 1: Create Edge class 
class Edge {
    String source;
    String destination;
    int weight;

    public Edge(String source, String destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

// Step 2: Create Graph class 
class Graph {
    Map<String, List<Edge>> adjacencyList = new HashMap<>();

    public void addEdge(String source, String destination, int weight) {
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>());

        // Add Edge
        adjacencyList.get(source).add(new Edge(source, destination, weight));
    }

    // Get neighbors 
    public List<Edge> getNeighbors(String node) {
        return adjacencyList.get(node);
    }

    // Get Nodes 
    public Set<String> getNodes() {
        return adjacencyList.keySet();
    }
}

public class BellmanFordImpl {
    public void bellmanFord(Graph graph, String startNode) {
        Map<String, Integer> distances = new HashMap<>();
        //used to keep track of shortest path 
        Map<String, String> predecessors = new HashMap<>();

        // Step 1: Initialize all Nodes with Max and null 
        for (String node : graph.getNodes()) {
            distances.put(node, Integer.MAX_VALUE);
            predecessors.put(node, null);
        }

        // Node a to a distance 
        distances.put(startNode, 0);

        // Step 2: Relax all Edges 
        int totalNodes = graph.getNodes().size();
        for (int i = 0; i < totalNodes - 1; i++) {
            for (String node : graph.getNodes()) {
                List<Edge> neighbors = graph.getNeighbors(node);
                if (neighbors != null) {
                    for (Edge edge : neighbors) {
                        relax(edge, distances, predecessors);
                    }
                }
            }
        }

        // Step 3: Check for negative cycle 
        for (String node : graph.getNodes()) {
            List<Edge> neighbors = graph.getNeighbors(node);
            if (neighbors != null) {
                for (Edge edge : neighbors) {
                    if (relax(edge, distances, predecessors)) {
                        System.out.println("Negative cycle is present");
                        return;
                    }
                }
            }
        }

        printShortestPath(startNode, distances, predecessors);
    }

    // Implement relax function
    public boolean relax(Edge edge, Map<String, Integer> distances, Map<String, String> predecessors) {
        String source = edge.source;
        String destination = edge.destination;
        int weight = edge.weight;

        int newDistance = distances.get(source) + weight;
        if (newDistance < distances.get(destination)) {
            distances.put(destination, newDistance);
            predecessors.put(destination, source);
            return true; // Indicates a change in distance
        }
        return false; // Indicates no change in distance
    }

    // Helper method to print shortest Path
    public void printShortestPath(String startNode, Map<String, Integer> distances, Map<String, String> predecessors) {
        System.out.println("Shortest paths from node " + startNode + ":");

        for (Map.Entry<String, Integer> entry : distances.entrySet()) {
            String node = entry.getKey();
            int distance = entry.getValue();

            List<String> path = new ArrayList<>();

            String currentNode = node;

            while (currentNode != null) {
                path.add(currentNode);
                currentNode = predecessors.get(currentNode);
            }

            // from the target node to the start node.
            Collections.reverse(path);
            System.out.println("To node " + node + ": Distance = " + distance + ", Path = " + path);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 2);
        graph.addEdge("B", "C", 5);
        graph.addEdge("B", "D", 10);
        graph.addEdge("C", "D", 3);
        graph.addEdge("D", "B", -6); // Negative weight edge

        BellmanFordImpl bellmanFord = new BellmanFordImpl();
        bellmanFord.bellmanFord(graph, "A");
    }
}
