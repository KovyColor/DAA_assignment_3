package util;

import model.*;
import org.json.*;
import java.nio.file.*;
import java.io.*;

public class JsonIO {
    public static Graph loadGraph(String path) throws IOException {
        String json = Files.readString(Path.of(path));
        JSONObject obj = new JSONObject(json);
        int vertices = obj.getInt("vertices");
        Graph graph = new Graph(vertices);
        JSONArray edges = obj.getJSONArray("edges");

        for (int i = 0; i < edges.length(); i++) {
            JSONObject e = edges.getJSONObject(i);
            graph.addEdge(e.getInt("src"), e.getInt("dest"), e.getDouble("weight"));
        }
        return graph;
    }

    public static void saveResults(String path, JSONObject results) throws IOException {
        Files.writeString(Path.of(path), results.toString(4));
    }
}
