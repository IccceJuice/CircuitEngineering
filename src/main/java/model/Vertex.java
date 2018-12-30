package model;

import controller.VertexView;

import java.util.LinkedList;

public abstract class Vertex {

    private double parameter;
    private boolean isIncluded = false;
    private double resistance = 1;
    private LinkedList<Vertex> minusAdjacency = new LinkedList<Vertex>();
    private LinkedList<Vertex> plusAdjacency = new LinkedList<Vertex>();
    private int[] numberPlusAdjacent = new int[0];
    public String name;
    private VertexView vertexView;
    private int ID;

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

    public void addPlusAdjacentVertex(int number){
        int[] newNumberPlus = new int[numberPlusAdjacent.length+1];
        newNumberPlus[numberPlusAdjacent.length] = number;
        numberPlusAdjacent = newNumberPlus;
    }

    public void setPlusAdjacency(LinkedList<Vertex> plusAdjacency) {
        this.plusAdjacency = plusAdjacency;
    }

    public void addPlusAdjacency(Vertex vertex){
        plusAdjacency.add(vertex);
    }

    public void setMinusAdjacency(LinkedList<Vertex> minusAdjacency) {
        this.minusAdjacency = minusAdjacency;
    }

    public int getID(){
        return ID;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public LinkedList<Vertex> getMinusAdjacency() {
        return minusAdjacency;
    }
    public void addMinusAdjacentVertex(Vertex vertex) {
        minusAdjacency.add(vertex);
    }

    public int[] getNumberPlusAdjacent() {
        return numberPlusAdjacent;
    }

    public VertexView getVertexView() {
        return vertexView;
    }

    public void setVertexView(VertexView vertexView) {
        this.vertexView = vertexView;
    }
}
