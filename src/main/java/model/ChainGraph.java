package model;

import java.util.LinkedList;

public class ChainGraph implements Graph {

    private int size;
    private LinkedList <Vertex> vertexMap;
    private boolean batteryIsConnected;




    public ChainGraph(){
        size = 0;
        vertexMap = null;
    }

    public boolean isReady(Vertex battery) {
        boolean[] visited = new boolean[size];
        visited = DFS(visited, battery);
        for (int i = 0; i < size; ++i){
            if (visited[i] != true){
                return false;
            }
        }
        if(batteryIsConnected) {
            return true;
        }
        return false;
    }


    public int size() {
        return size;
    }

    public LinkedList <Vertex> getVertexMap() {
        return vertexMap;
    }


    public void setBatteryIsConnected(boolean batteryIsConnected) {
        this.batteryIsConnected = batteryIsConnected;
    }

    public void turnOn(){
        if (isReady(vertexMap.getFirst())){
            boolean[] visited = new boolean[size];
            DFS(visited, vertexMap.getFirst());
        }
    }

    public boolean[] DFS(boolean[] visited, Vertex vertex){
        visited[vertex.getID()] = true;
        vertex.draw();
        LinkedList<Vertex> adjacentVertex = vertex.getPlusAdjacency();
        for (Vertex v: adjacentVertex){
            if(v!=null && !visited[v.getID()])
                visited = DFS(visited, v);
        }
        return visited;
    }

    public void setGraph(LinkedList<Vertex> vertexList) {
        this.vertexMap = vertexList;
    }

    public void addVertex(Vertex vertex) {
        vertexMap.add(vertex);
        size++;
    }

    public LinkedList<Vertex> getGraph() {
        return vertexMap;
    }
}
