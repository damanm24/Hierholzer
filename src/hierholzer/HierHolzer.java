/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hierholzer;

import java.util.List;

/**
 *
 * @author daman
 */
public class HierHolzer {

    /**
     * ONLY WORKS ON DIRECTED NON-WEIGHTED GRAPHS
     */
    public static void main(String[] args) {
        Vertex a = new Vertex(0);
        Vertex b = new Vertex(1);
        Vertex c = new Vertex(2);
        Vertex d = new Vertex(3);
        Vertex e = new Vertex(4);
        Vertex f = new Vertex(5);
        Vertex g = new Vertex(6);
        
        Graph graph = new Graph();
        
        graph.addEdge(a,b);
        graph.addEdge(b,c);
        graph.addEdge(c,d);
        graph.addEdge(d,e);
        graph.addEdge(e,c);
        graph.addEdge(c,a);
        graph.addEdge(a,f);
        graph.addEdge(f,e);
        graph.addEdge(e,g);
        graph.addEdge(g,a);
        

        
        List<Edge> path = graph.checkPath(a, a);
        graph.pathString(path);
    }
    
}
