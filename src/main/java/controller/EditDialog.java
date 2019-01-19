package controller;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.Edge;
import model.Graph.Graph;
import model.Vertex.Vertex;


public abstract class EditDialog {
    public abstract void setValues(Graph graph, Vertex vertex, AnchorPane anchorPane, Label label);
}
