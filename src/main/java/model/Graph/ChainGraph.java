package model.Graph;


import model.Edge;
import model.Vertex.Vertex;

import java.util.ArrayList;

public class ChainGraph implements Graph {

    private int vertexSize;
    private int edgeSize;
    private ArrayList<Vertex> vertices;
    private ArrayList<Edge> edges;
    private boolean batteryIsConnected;



    public ChainGraph(){
        vertexSize = 0;
        edgeSize = 0;
        vertices = null;
        edges = new ArrayList<Edge>();
    }

//    public boolean isReady(Vertex battery) {
//        boolean[] visited = new boolean[vertexSize];
//        visited = DFS(visited, battery);
//        for (int i = 0; i < vertexSize; ++i){
//            if (visited[i] != true){
//                return false;
//            }
//        }
//        if(batteryIsConnected) {
//            return true;
//        }
//        return false;
//    }


    public int vertexSize() {
        return vertexSize;
    }
    public int edgeSize() { return edgeSize; }

    public void setBatteryIsConnected(boolean batteryIsConnected) {
        this.batteryIsConnected = batteryIsConnected;
    }

    public void turnOn(){
//        if (isReady(vertices.getFirst())){
//            boolean[] visited = new boolean[vertexSize];
//            DFS(visited, vertices.getFirst());
//        }
    }

    //todo DON'T TOUCH
//    public boolean[] DFS(boolean[] visited, Vertex vertex){
//        visited[vertex.getID()] = true;
//        vertex.draw();
//        LinkedList<Vertex> adjacentVertex = vertex.getPlusAdjacency();
//        for (Vertex v: adjacentVertex){
//            if(v!=null && !visited[v.getID()])
//                visited = DFS(visited, v);
//        }
//        return visited;
//    }

    public void setGraph(ArrayList<Vertex> vertexList) {
        this.vertices = vertexList;
    }

    public void addVertex( Vertex vertex) {
        vertices.add(vertex);
        vertexSize++;
    }
    public void addEdge(Edge edge){
        edges.add(edge);
        edgeSize++;
    }
    public ArrayList<Edge> getEdges() { return edges;}
    public ArrayList<Vertex> getVertices() {
        return vertices;
    }
}
