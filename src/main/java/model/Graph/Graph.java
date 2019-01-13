package model.Graph;

import model.Edge;
import model.Vertex.Vertex;

import java.util.*;

public interface Graph {
    void setGraph(ArrayList<Vertex> vertexMap);
    void addVertex( Vertex vertex);
    void addEdge(Edge edge);
    int edgeSize();
    void turnOn();
    ArrayList<Vertex> getVertices();
    int vertexSize();
    void printCycles();
}
