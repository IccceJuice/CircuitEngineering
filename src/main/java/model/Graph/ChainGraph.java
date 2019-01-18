package model.Graph;


import model.Edge;
import model.Vertex.Vertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChainGraph implements Graph {

    private int vertexSize;
    private int edgeSize;
    private ArrayList<Vertex> vertices;
    private ArrayList<Edge> edges;
    private boolean batteryIsConnected;
    private ArrayList<String> catalogCycles = new ArrayList<String>();
    private int batteryID;


    public ChainGraph(){
        vertexSize = 0;
        edgeSize = 0;
        vertices = null;
        edges = new ArrayList<Edge>();
        batteryID = -1;
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
    private void DFScycle(int u, int endV, ArrayList<Edge> E, int[] color, int unavailableEdge, ArrayList<Integer> cycle) {
        //если u == endV, то эту вершину перекрашивать не нужно, иначе мы в нее не вернемся, а вернуться необходимо
        if (u != endV)
            color[u] = 2;
        else if (cycle.size() >= 2) {
            Collections.reverse(cycle);
            String s = cycle.toArray()[0].toString();
            for (int i = 1; i < cycle.size(); i++)
                s += "-" + cycle.toArray()[i].toString();
            boolean flag = false; //есть ли палиндром для этого цикла графа в List<string> catalogCycles?
            for (int i = 0; i < catalogCycles.size(); i++) {
                if (catalogCycles.toArray()[i].toString().equals(s)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                Collections.reverse(cycle);
                s = cycle.toArray()[0].toString();
                for (int i = 1; i < cycle.size(); i++)
                    s += "-" + cycle.toArray()[i].toString();
                catalogCycles.add(s);
            }
            return;
        }
        for (int w = 0; w < E.size(); w++) {
            if (w == unavailableEdge)
                continue;
            if (color[E.get(w).getTo().getID()-1] == 1 && (E.get(w).getFrom().getID()-1) == u) {
                ArrayList<Integer> cycleNEW = new ArrayList<Integer>(cycle);
                cycleNEW.add(E.get(w).getTo().getID() );
                DFScycle(E.get(w).getTo().getID()-1, endV, E, color, w, cycleNEW);
                color[E.get(w).getTo().getID()-1] = 1;
            }
            else if (color[E.get(w).getFrom().getID()-1] == 1 && (E.get(w).getTo().getID()-1) == u) {
                ArrayList<Integer> cycleNEW = new ArrayList<Integer>(cycle);
                cycleNEW.add(E.get(w).getFrom().getID());
                DFScycle(E.get(w).getFrom().getID()-1, endV, E, color, w, cycleNEW);
                color[E.get(w).getFrom().getID()-1] = 1;
            }
        }
    }
    private void cyclesSearch() {
        catalogCycles.removeAll(catalogCycles);
        int[] color = new int[vertices.size()];
//        for (int i = 0; i < vertices.size(); i++)
//        {
            for (int k = 0; k < vertices.size(); k++)
                color[k] = 1;
            ArrayList<Integer> cycle = new ArrayList<Integer>();
            cycle.add(batteryID + 1);
            DFScycle(batteryID, batteryID, edges, color, -1, cycle);
//        }
    }
    public void printCycles(){
        cyclesSearch();
        for(int i = 0; i < catalogCycles.size(); ++i){
            System.out.println(catalogCycles.toArray()[i]);
        }
    }

    @Override
    public void setBatteryID(int batteryID) {
        this.batteryID = batteryID;
    }
}
