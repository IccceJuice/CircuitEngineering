package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Edge;
import model.Graph.Graph;
import model.Vertex.Vertex;

import java.net.URL;
import java.util.ResourceBundle;

public class EdgeEditDialog extends EditDialog implements Initializable{

    private Edge edge;
    private Graph graph;
    private ResourceBundle resourceBundle;
    private AnchorPane anchorPane;

    @FXML
    private TextField txtFrom;
    @FXML
    private TextField txtTo;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        edge = new Edge();
        this.resourceBundle = resources;
    }

    public void closeAction(ActionEvent actionEvent){
        Node source = (Node)actionEvent.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.hide();
    }

    public void actionSave(ActionEvent actionEvent){
        if (!checkValues()) return;
        if (txtFrom.getText().length() != 0) {
            edge.setFrom(graph.getVertices().get(Integer.parseInt(txtFrom.getText()) - 1));
        }
        System.out.println(edge.getFrom().getName());
        if (txtTo.getText().length() != 0) {
            edge.setTo(graph.getVertices().get(Integer.parseInt(txtTo.getText()) - 1));
        }
        System.out.println(edge.getTo().getName());
        closeAction(actionEvent);
    }

    public void setValues(Graph graph, Edge edge, AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
        this.graph = graph;
        this.edge = edge;
        txtFrom.setText(null);
        txtTo.setText(null);
    }

    public Edge getEdge() {
        return edge;
    }

    private boolean checkValues(){
//        if (parameterTF.getText().trim().length() == 0
//                || Double.parseDouble(parameterTF.getText()) < 0
//                || resistanceTF.getText().trim().length() == 0
//                || Double.parseDouble(resistanceTF.getText()) <= 0){
//            DialogManager.showErrorDialog();
//            return false;
//        }
        return true;
    }

    @Override
    public void setValues(Graph graph, Vertex vertex, AnchorPane anchorPane, Label label) {

    }

    public void deleteEdge(ActionEvent actionEvent) {
        anchorPane.getChildren().removeAll(edge.getEdgeView().getLines());
        edge.getFrom().getAdjacentEdges().remove(edge);
        edge.getTo().getAdjacentEdges().remove(edge);
        graph.getEdges().remove(edge);
        closeAction(actionEvent);
    }
}
