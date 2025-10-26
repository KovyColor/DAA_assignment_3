package model;

import java.util.*;

public class Graph {
    public int vertices;
    public List<Edge> edges = new ArrayList<>();
    public Map<Integer, List<Edge>> adjList = new HashMap<>();

    public Graph(int vertices) {
        this.vertices = vertices;
        for (int i = 0; i < vertices; i++)
            adjList.put(i, new ArrayList<>());
    }

    public void addEdge(int src, int dest, double weight) {
        Edge e = new Edge(src, dest, weight);
        edges.add(e);
        adjList.get(src).add(e);
        adjList.get(dest).add(new Edge(dest, src, weight));
    }
}
