package model;

import java.util.LinkedList;
import java.util.List;

public interface Graph {

    void setGraph(LinkedList<Vertex> vertexList);
    void addVertex(Vertex vertex);
    void turnOn(Vertex first);
    LinkedList<Vertex> getGraph();
}
