package model;

import java.util.LinkedList;
import java.util.List;

public class Resistor extends Vertex {

    private String name = "Resistor";
    private LinkedList<Vertex> vertexList;
    private int ID;

    public Resistor(LinkedList<Vertex> vertexList){
        this.vertexList = vertexList;
    }

    public void draw() {
        System.out.println(name);
    }
}
