package model;

import controller.VertexView;

import java.util.LinkedList;

public abstract class Vertex {

    private double parameter;
    private boolean isIncluded = false;
    private double resistance = 1;
    private LinkedList<Vertex> minusAdjacency = new LinkedList<Vertex>();
    private LinkedList<Vertex> plusAdjacency = new LinkedList<Vertex>();
    private VertexID ID;
    public String name;
    private VertexView vertexView;

    public double getParameter() {
        return parameter;
    }

    public void setParameter(double parameter) {

        this.parameter = parameter;
    }

    public String getName() {
        return name;
    }

    public double getResistance() {
        return resistance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setResistance(double resistance) {
        this.resistance = resistance;
    }

    public boolean isIncluded(){
        return isIncluded;
    }

    abstract public void draw();

    public LinkedList<Vertex> getPlusAdjacency(){
        return plusAdjacency;
    }

    public void addPlusAdjacentVertex(Vertex vertex){
        plusAdjacency.add(vertex);
    }

    public int getID(){
        return ID.getID();
    }

    public void setID(int ID){
        this.ID.setID(ID);
    }

    public LinkedList<Vertex> getMinusAdjacency() {
        return minusAdjacency;
    }
    public void addMinusAdjacentVertex(Vertex vertex) {
        minusAdjacency.add(vertex);
    }

    public VertexView getVertexView() {
        return vertexView;
    }

    public void setVertexView(VertexView vertexView) {
        this.vertexView = vertexView;
    }
}
