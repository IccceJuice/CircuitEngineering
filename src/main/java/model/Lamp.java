package model;

import java.util.LinkedList;

public class Lamp extends Vertex {

    private String name = "Lamp";
    private LinkedList<Vertex> vertexList;

    public Lamp(LinkedList<Vertex> vertexList){
        this.vertexList = vertexList;
    }

    public void draw() {
        System.out.println(name);
    }
}
