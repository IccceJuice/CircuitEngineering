package model;

import java.util.LinkedList;

public abstract class Vertex {


    private boolean isIncluded = false;
    private double resistance = 0;
    private LinkedList<Vertex> minusAdjacency = new LinkedList<Vertex>();
    private LinkedList<Vertex> plusAdjacency = new LinkedList<Vertex>();
    private int ID = -1;
    public String name;


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
}
