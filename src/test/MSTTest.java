package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import model.*;
import algorithms.*;

public class MSTTest {
    @Test
    public void testPrimAndKruskalSameCost() {
        Graph g = new Graph(4);
        g.addEdge(0,1,1);
        g.addEdge(0,2,3);
        g.addEdge(1,2,1);
        g.addEdge(2,3,4);
        g.addEdge(1,3,2);

        Prim.Result p = Prim.findMST(g);
        Kruskal.Result k = Kruskal.findMST(g);

        assertEquals(p.totalCost, k.totalCost, 1e-6);
        assertEquals(g.vertices - 1, p.mstEdges.size());
        assertEquals(g.vertices - 1, k.mstEdges.size());
    }
}
