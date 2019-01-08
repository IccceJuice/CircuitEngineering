package model;

import controller.ElementView;
import model.Graph.Graph;
import model.Vertex.Vertex;

public class Edge {

    private Vertex from = null;
    private Vertex to = null;
    private int amperage = 0;
    private ElementView elementView;
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
    public void setFromID(Graph graph, int ID){
        from = graph.getVertices().get(ID);
    }

    public void setElementView(ElementView elementView) {
        this.elementView = elementView;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
