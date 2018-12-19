package model;

import java.util.LinkedList;

public class Ammeter extends Vertex {

    private double amperage = 0;
    private LinkedList<Vertex> vertexList;
    private String name = "Ammeter";

    Ammeter(LinkedList<Vertex> vertexList){
        this.vertexList = vertexList;
    }

    public double getAmperage() {
        return amperage;
    }

    public void setAmperage(double amperage) {
        this.amperage = amperage;
    }

    public void draw() {
        System.out.println(name);
    }
}
