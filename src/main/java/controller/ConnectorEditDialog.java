package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Graph.Graph;
import model.Vertex.Connector;
import model.Vertex.Vertex;

import java.net.URL;
import java.util.ResourceBundle;

public class ConnectorEditDialog extends EditDialog implements Initializable {



    private Vertex connector;
    private ResourceBundle resourceBundle;
    private Graph graph;

    @FXML
    private TextField txtLeft;
    @FXML
    private TextField txtRight;
    @FXML
    private TextField txtTop;
    @FXML
    private TextField txtBottom;
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
        connector.setParameter(0);
        connector.setResistance(0);
        if (txtRight.getText().length() != 0)
            connector.setNext(graph, Integer.parseInt(txtRight.getText()) - 1);
        //System.out.println(connector.getNext().getName());
        if (txtLeft.getText().length() != 0)
            connector.setPrev(graph, Integer.parseInt(txtLeft.getText()) - 1);
//        connector.setTop(graph, Integer.parseInt(txtTop.getText()) - 1);
//        connector.setBottom(graph, Integer.parseInt(txtBottom.getText()) - 1);
        closeAction(actionEvent);
    }

    public void setValues(Graph graph, Vertex vertex) {
        this.graph = graph;
        this.connector = vertex;
        if (vertex.getPrev() != null) {
            txtLeft.setText(String.valueOf(vertex.getPrev().getID()));
        }
        if (vertex.getNext() != null) {
            txtRight.setText(String.valueOf(vertex.getNext().getID()));
        }
        if (vertex.getTop() != null) {
            txtTop.setText(String.valueOf(vertex.getTop().getID()));
        }
        if (vertex.getBottom() != null) {
            txtBottom.setText(String.valueOf(vertex.getBottom().getID()));
        }
    }

    public Vertex getConnector() {
        return connector;
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
}
