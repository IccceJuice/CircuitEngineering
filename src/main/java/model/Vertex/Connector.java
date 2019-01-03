package model.Vertex;

import java.util.LinkedList;

public class Connector extends Vertex {

    private Vertex top, bottom;
    private LinkedList<Vertex> vertexList;
    private String name = "Connector";

    public void draw() {
        System.out.println(name);
    }

    @Override
    public String getName() {
        return name;
    }

}
