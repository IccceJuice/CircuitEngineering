package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import model.Edge;
import model.Graph.Graph;
import model.Vertex.Vertex;

import java.net.URL;
import java.util.ResourceBundle;

public class VertexEditDialog extends EditDialog implements Initializable{


    private Vertex vertex;
    private ResourceBundle resourceBundle;
    private Graph graph;
    private AnchorPane anchorPane;
    private Label label;

    @FXML
    private TextField parameterTF;
    @FXML
    private TextField resistanceTF;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resourceBundle = resources;
    }
    public void closeAction(ActionEvent actionEvent){
        Node source = (Node)actionEvent.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.hide();
    }

    public void actionSave(ActionEvent actionEvent){
        if (!checkValues()) return;
        vertex.setParameter(Double.parseDouble(parameterTF.getText()));
        vertex.setResistance(Double.parseDouble(resistanceTF.getText()));
        
//        vertex.setNext(graph, Integer.parseInt(toTF.getText()) - 1);
//        System.out.println(vertex.getNext().getName());
//        vertex.setPrev(graph, Integer.parseInt(fromTF.getText()) - 1);
        closeAction(actionEvent);
    }

    public void setValues(Graph graph, Vertex vertex, AnchorPane anchorPane, Label label) {
        this.anchorPane = anchorPane;
        this.graph = graph;
        this.vertex = vertex;
        this.label = label;

        parameterTF.setText(String.valueOf(vertex.getParameter()));
        resistanceTF.setText(String.valueOf(vertex.getResistance()));
//        if (vertex.getPrev() != null) {
//            fromTF.setText(String.valueOf(vertex.getPrev().getID() + 1));
//        }
//        if (vertex.getNext() != null) {
//            toTF.setText(String.valueOf(vertex.getNext().getID() + 1));
//        }
    }

    public Vertex getVertex() {
        return vertex;
    }

    private boolean checkValues(){
        if (parameterTF.getText().trim().length() == 0
                || Double.parseDouble(parameterTF.getText()) < 0
                || resistanceTF.getText().trim().length() == 0
                || Double.parseDouble(resistanceTF.getText()) <= 0
                 ){
            DialogManager.showErrorDialog();
            return false;
        }
        return true;
    }

    public void deleteElement(ActionEvent actionEvent) {
        anchorPane.getChildren().remove(vertex.getVertexView().getImageView());
        anchorPane.getChildren().remove(label);
        for (Edge adjacentEdge : vertex.getAdjacentEdges()) {
            anchorPane.getChildren().removeAll(adjacentEdge.getEdgeView().getLines());
            graph.getEdges().remove(adjacentEdge);
        }
        if (vertex.getName().equals("Battery")){
            graph.setBatteryConnected(false);
        }
        graph.getVertices().remove(vertex);
        for (int i = 0; i < graph.getVertices().size(); ++i) {
            graph.getVertices().get(i).setID(i+1);
            graph.getVertices().get(i).getVertexView().setTextLabel("(" + String.valueOf(i+1) + ")");
        }

        closeAction(actionEvent);
    }
}
