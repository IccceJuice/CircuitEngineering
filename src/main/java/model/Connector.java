package model;

import java.util.LinkedList;

public class Connector extends Vertex {


    private LinkedList<Vertex> vertexList;
    private String name = "Connector";

    public void draw() {
        System.out.println(name);
    }
}
