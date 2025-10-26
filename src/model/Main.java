package model;

import model.*;
import algorithms.*;
import util.*;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) throws Exception {
        String inputPath = "input.json";
        String outputPath = "output.json";

        Graph graph = JsonIO.loadGraph(inputPath);

        Prim.Result prim = Prim.findMST(graph);
        Kruskal.Result kruskal = Kruskal.findMST(graph);

        JSONObject out = new JSONObject();
        out.put("vertices", graph.vertices);
        out.put("edges", graph.edges.size());
        out.put("Prim_total_cost", prim.totalCost);
        out.put("Kruskal_total_cost", kruskal.totalCost);
        out.put("Prim_time_ms", prim.timeMs);
        out.put("Kruskal_time_ms", kruskal.timeMs);
        out.put("Prim_operations", prim.operations);
        out.put("Kruskal_operations", kruskal.operations);

        JsonIO.saveResults(outputPath, out);

        System.out.println(out.toString(4));
    }
}
