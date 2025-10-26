package algorithms;

import model.*;
import java.util.*;

public class Prim {
    public static class Result {
        public List<Edge> mstEdges = new ArrayList<>();
        public double totalCost = 0;
        public long operations = 0;
        public long timeMs;
    }

    public static Result findMST(Graph graph) {
        Result result = new Result();
        long start = System.currentTimeMillis();

        boolean[] inMST = new boolean[graph.vertices];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        inMST[0] = true;
        pq.addAll(graph.adjList.get(0));

        while (!pq.isEmpty() && result.mstEdges.size() < graph.vertices - 1) {
            Edge e = pq.poll();
            result.operations++;

            if (inMST[e.dest]) continue;
            inMST[e.dest] = true;
            result.mstEdges.add(e);
            result.totalCost += e.weight;

            for (Edge next : graph.adjList.get(e.dest)) {
                if (!inMST[next.dest])
                    pq.add(next);
            }
        }

        result.timeMs = System.currentTimeMillis() - start;
        return result;
    }
}
