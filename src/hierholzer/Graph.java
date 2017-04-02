/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hierholzer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author daman
 */
public class Graph {
    
    List<Edge> Edges = new ArrayList<Edge>();
    List<Vertex> Vertices = new ArrayList<Vertex>();
    
    public void pathString(List<Edge> path) {
        for(Edge direction : path) {
            System.out.println(direction.start.label + "->" + direction.end.label);
        }
    }
    
    public Graph addVertex(Vertex v) {
        Vertices.add(v);
        return this;
    }
    
    public Graph addEdge(Vertex start, Vertex end) {
        if(!doesVertexExist(start)) {
            addVertex(start);
        }
        if(!doesVertexExist(end)) {
            addVertex(end);
        }
        
        Edge e = new Edge(start, end);
        Edges.add(e);
        return this;
    }
    
    public boolean doesVertexExist(Vertex v) {
        return (Vertices.indexOf(v) >= 0);
    }
    
    public boolean allEdgesVisited() {
        for(Edge e : Edges) {
            if(e.visited = false) {
                return false;
            }
        }
        return true;
    }
    
    public Edge getUnvisitedEdge(Vertex v) {
        for(Edge e: Edges) {
            if (e.visited == false && e.start.label == v.label) {
                e.visited = true;
                return e;
            }
        }
        return null;
    }
    
    public Vertex getUnvisitedBranch(Vertex v) {
        for(Edge e : Edges) {
            if(e.visited == false && e.start.label == v.label) {
                e.visited = true;
                return e.end;
            }
        }
        return null;
    }
    
    public void reset() {
        for(Edge e: Edges) {
            e.visited = false;
        }
        for(Vertex v : Vertices) {
            v.visited = false;
        }
    }
    
    public List<Edge> startPathSearch(Vertex start) {
        Stack<Edge> frontTrace = new Stack<Edge>();
        Stack<Edge> backTrace = new Stack<Edge>();
        Edge e = getUnvisitedEdge(start);
        
        while(e != null) {
            e.visited = true;
            frontTrace.push(e);
            e = getUnvisitedEdge(e.end);
        }
        
        while(frontTrace.isEmpty() == false) {
            e = frontTrace.pop();
            backTrace.push(e);
            e = getUnvisitedEdge(e.start);
            while(e != null) {
                e.visited = true;
                frontTrace.push(e);
                e = getUnvisitedEdge(e.end);
            }
        }
        
        List<Edge> path = new LinkedList<Edge>();
        while(backTrace.isEmpty() == false) {
            Edge pathEdge =  backTrace.pop();
            path.add(pathEdge);
        }
        
        return path;
    }
    
    public List<Edge> checkPath(Vertex start, Vertex end) {
        List<Edge> path = startPathSearch(start);
        
        if(path == null || path.size() == 0) {
            System.out.println("No Euler Path found.");
        } else {
            if(path.get(path.size()-1).end == end) {
                System.out.println("Euler Path found!");
            } else {
                System.out.println("No Euler Path found.");
            }
        }
        return path;
    }
    
}
