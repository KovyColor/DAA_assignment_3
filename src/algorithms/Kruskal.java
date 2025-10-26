package algorithms;

import model.*;
import java.util.*;

public class Kruskal {
    static class UnionFind {
        int[] parent, rank;
        long ops = 0;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            ops++;
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int x, int y) {
            int rootX = find(x), rootY = find(y);
            if (rootX == rootY) return false;
            ops++;
            if (rank[rootX] < rank[rootY]) parent[rootX] = rootY;
            else if (rank[rootX] > rank[rootY]) parent[rootY] = rootX;
            else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }
    }

    public static class Result {
        public List<Edge> mstEdges = new ArrayList<>();
        public double totalCost = 0;
        public long operations = 0;
        public long timeMs;
    }

    public static Result findMST(Graph graph) {
        Result result = new Result();
        long start = System.currentTimeMillis();

        List<Edge> edges = new ArrayList<>(graph.edges);
        Collections.sort(edges);
        UnionFind uf = new UnionFind(graph.vertices);

        for (Edge e : edges) {
            if (uf.union(e.src, e.dest)) {
                result.mstEdges.add(e);
                result.totalCost += e.weight;
            }
        }

        result.operations = uf.ops;
        result.timeMs = System.currentTimeMillis() - start;
        return result;
    }
}
