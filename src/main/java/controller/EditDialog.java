package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import model.Graph.Graph;
import model.Vertex.Vertex;

import java.net.URL;
import java.util.ResourceBundle;

public class EditDialog implements Initializable{


    private Vertex vertex;
    private ResourceBundle resourceBundle;


    @FXML
    private TextField parameterTF;
    @FXML
    private TextField resistanceTF;
    @FXML
    private TextField fromTF;
    @FXML
    private TextField toTF;
    private Graph graph;


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
        vertex.addNextVertex(graph, Integer.parseInt(toTF.getText()) - 1);
        System.out.println(vertex.getNext().getName());
        vertex.addPrevVertex(graph, Integer.parseInt(fromTF.getText()) - 1);
        closeAction(actionEvent);
    }

    public void setValues(Graph graph, Vertex vertex) {
        this.graph = graph;
        this.vertex = vertex;
        parameterTF.setText(String.valueOf(vertex.getParameter()));
        resistanceTF.setText(String.valueOf(vertex.getResistance()));

    }

    public Vertex getVertex() {
        return vertex;
    }

    private boolean checkValues(){
        if (parameterTF.getText().trim().length() == 0
                || Double.parseDouble(parameterTF.getText()) < 0
                || resistanceTF.getText().trim().length() == 0
                || Double.parseDouble(resistanceTF.getText()) <= 0){
            DialogManager.showErrorDialog();
            return false;
        }
        return true;
    }
}
