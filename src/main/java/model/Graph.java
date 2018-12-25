package model;

import controller.VIew.VertexView;

import java.util.*;

public interface Graph {

    void setGraph(ArrayList<Vertex> vertexMap);
    void addVertex( Vertex vertex);
    void turnOn();
    ArrayList<Vertex> getGraph();
    int size();
}
