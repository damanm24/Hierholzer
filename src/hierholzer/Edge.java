/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hierholzer;

/**
 *
 * @author daman
 */
public class Edge {
    public Vertex start;
    public Vertex end;
    public boolean visited = false;
    
    public Edge(Vertex start, Vertex end) {
        this.start = start;
        this.end = end;
    }
    
    public String toString() {
        return (String) (this.start.label + "->" + this.end.label);
    }
}
