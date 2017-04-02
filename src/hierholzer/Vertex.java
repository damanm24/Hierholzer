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
public class Vertex {
    public int label = 0;
    public boolean visited = false;
    
    public Vertex(int label) {
        this.label = label;
    }
    
    public String toString() {
        return Integer.toString(this.label);
    }
}
