package model;

import model.Vertex.Vertex;
import controller.EdgeView;

public class Edge {

    private Vertex from = null;
    private Vertex to = null;
    private int amperage = 0;
    private EdgeView edgeView;
    private int ID = -1;
    public Edge (){

    }

    public void setFrom(Vertex from) {
        this.from = from;
    }

    public void setTo(Vertex to) {
        this.to = to;
    }

    public Vertex getFrom() {
        return from;
    }

    public Vertex getTo() {
        return to;
    }

    public void setEdgeView(EdgeView edgeView) {
        this.edgeView = edgeView;
    }

    public EdgeView getEdgeView() {
        return edgeView;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
