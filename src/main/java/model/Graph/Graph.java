package model.Graph;

import model.Vertex.Vertex;

import java.util.*;

public interface Graph {

    void setGraph(ArrayList<Vertex> vertexMap);
    void addVertex( Vertex vertex);
    void turnOn();
    ArrayList<Vertex> getGraph();
    int size();
}
