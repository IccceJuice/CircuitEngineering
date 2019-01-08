package model.Vertex;


import model.Graph.Graph;

public class Connector extends Vertex {

    private Vertex top = null;
    private Vertex bottom = null;
    private String name = "Connector";

    public void draw() {
        System.out.println(name);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setTop(Graph graph, int numberOfVertex) {
        top = graph.getVertices().get(numberOfVertex);
    }


    public void setBottom(Graph graph, int numberOfVertex) {
        bottom = graph.getVertices().get(numberOfVertex);
    }

    public Vertex getTop() {
        return top;
    }

    public Vertex getBottom() {
        return bottom;
    }
}
