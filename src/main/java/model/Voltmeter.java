package model;

import java.util.LinkedList;

public class Voltmeter extends Vertex {

    private String name = "Voltmeter";
    private LinkedList<Vertex> vertexList;

    Voltmeter(LinkedList<Vertex> vertexList){
        this.vertexList = vertexList;
    }

    public void draw() {
        System.out.println(name);
    }
}
