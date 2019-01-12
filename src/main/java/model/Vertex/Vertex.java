package model.Vertex;

import controller.ElementView;
import model.Graph.Graph;

public abstract class Vertex {

    private double parameter;
    private boolean isIncluded = false;
    private double resistance = 1;
    private Vertex next;
    private Vertex prev;
    public String name;
    private ElementView elementView;
    private int ID = -1;

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

    public Vertex getPrev() {
        return prev;
    }

    public Vertex getNext() {
        return next;
    }

    public void setPrev(Vertex prev) {
        this.prev = prev;
    }

    public void setNext(Vertex next) {
        this.next = next;
    }

//    public void addPlusAdjacentVertex(int number){
//        int[] newNumberPlus = new int[numberPlusAdjacent.length+1];
//        newNumberPlus[numberPlusAdjacent.length] = number;
//        numberPlusAdjacent = newNumberPlus;
//    }

//    public void setPlusAdjacency(LinkedList<Vertex> plusAdjacency) {
//        this.plusAdjacency = plusAdjacency;
//    }

    public void setNext(Graph graph, int numberOfVertex){
        next = graph.getVertices().get(numberOfVertex);
    }
    public void setPrev(Graph graph, int numberOfVertex){
        prev = graph.getVertices().get(numberOfVertex);
    }

//    public void setMinusAdjacency(LinkedList<Vertex> minusAdjacency) {
//        this.minusAdjacency = minusAdjacency;
//    }

    public int getID(){
        return ID;
    }

    public void setID(int ID){
        this.ID = ID;
    }

//    public LinkedList<Vertex> getMinusAdjacency() {
//        return minusAdjacency;
//    }
//    public void addMinusAdjacentVertex(Vertex vertex) {
//        minusAdjacency.add(vertex);
//    }
//
//    public int[] getNumberPlusAdjacent() {
//        return numberPlusAdjacent;
//    }

    public ElementView getElementView() {
        return elementView;
    }

    public void setElementView(ElementView elementView) {
        this.elementView = elementView;
    }

    public abstract Vertex getTop();

    public abstract Vertex getBottom();
}
