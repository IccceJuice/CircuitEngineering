package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Edge;
import model.Graph.Graph;
import model.Vertex.*;
import javafx.scene.shape.Line;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainWindow implements Initializable {


    private Stage mainStage;
    private static Graph graph;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ImageView imgBattery;
    @FXML
    private ImageView imgResistor;
    @FXML
    private ImageView imgLamp;
    @FXML
    private ImageView imgAmmeter;
    @FXML
    private ImageView imgVoltmeter;
    @FXML
    private ImageView imgConnector;

    private FXMLLoader fxmlLoader = new FXMLLoader();
    private FXMLLoader fxmlLoaderCnctr = new FXMLLoader();
    private FXMLLoader fxmlLoaderEdge = new FXMLLoader();

    private Parent fxmlEdit;
    private VertexEditDialog vertexEditDialog;
    private Stage vertexEdit;

    private Parent fxmlCnctrEdit;
    private ConnectorEditDialog connectorEditDialog;
    private Stage cnctrEdit;

    private Parent fxmlEdgeEdit;
    private EdgeEditDialog edgeEditDialog;
    private Stage edgeEdit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imgBattery.setImage(new Image("/elements/Battery.png"));
        imgResistor.setImage(new Image("/elements/Res.png"));
        imgLamp.setImage(new Image("/elements/lampOff.png"));
        imgAmmeter.setImage(new Image("/elements/Ammeter.png"));
        imgVoltmeter.setImage(new Image("/elements/Voltmeter.png"));
        imgConnector.setImage(new Image("/elements/dot.png"));

        fxmlLoader.setLocation(getClass().getResource("/fxml/EditDialog.fxml"));
        fxmlLoader.setResources(ResourceBundle.getBundle("bundles.Locale", new Locale("en")));
        try {
            fxmlEdit = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        vertexEditDialog = fxmlLoader.getController();


        fxmlLoaderCnctr.setLocation(getClass().getResource("/fxml/ConnectorEditDialog.fxml"));
        fxmlLoaderCnctr.setResources(ResourceBundle.getBundle("bundles.Locale", new Locale("en")));
        try {
            fxmlCnctrEdit = fxmlLoaderCnctr.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        connectorEditDialog = fxmlLoaderCnctr.getController();

        fxmlLoaderEdge.setLocation(getClass().getResource("/fxml/EdgeEditDialog.fxml"));
        fxmlLoaderEdge.setResources(ResourceBundle.getBundle("bundles.Locale", new Locale("en")));
        try {
            fxmlEdgeEdit = fxmlLoaderEdge.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        edgeEditDialog = fxmlLoaderEdge.getController();
        vertexEdit = initStage(vertexEdit, fxmlEdit);
        cnctrEdit = initStage(cnctrEdit, fxmlCnctrEdit);
        edgeEdit = initStage(edgeEdit, fxmlEdgeEdit);
    }

    private void initEditDialog( Parent parent){
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/EditDialog.fxml"));
        fxmlLoader.setResources(ResourceBundle.getBundle("bundles.Locale", new Locale("en")));
        parent = null;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setGraph(Graph graphInit) {
        graph = graphInit;

    }


    public void addBattery(MouseDragEvent mouseDragEvent) {

    }

    public void actionButtonPressed(ActionEvent actionEvent) {

        Object source = actionEvent.getSource();

        if (!(source instanceof Button)) return;

        Button clickedButton = (Button) source;
        String title = "";
        Image image;
        switch (clickedButton.getId()) {
            case "btnAddBattery":
                image = new Image("/elements/Battery.png");
                ElementView viewBattery = new ElementView(47, 50, 20, image, "");
                Battery battery = new Battery();
                createElement( battery, viewBattery, vertexEditDialog, fxmlEdit, vertexEdit);
                break;
            case "btnAddResistor":
                image = new Image("/elements/Res.png");
                ElementView viewResistor = new ElementView(15, 140, 35, image, "");
                Resistor resistor = new Resistor();

                createElement(resistor, viewResistor, vertexEditDialog, fxmlEdit, vertexEdit);
                break;
            case "btnAddLamp":
                image = new Image("/elements/lampOff.png");
                ElementView viewLamp = new ElementView(16, 230, 42, image, "");
                Lamp lamp = new Lamp();
                createElement(lamp, viewLamp, vertexEditDialog, fxmlEdit, vertexEdit);
                break;
            case "btnAddAmmeter":
                image = new Image("/elements/Ammeter.png");
                ElementView viewAmmeter = new ElementView(15, 320, 35, image, "");
                Ammeter ammeter = new Ammeter();
                createElement(ammeter, viewAmmeter, vertexEditDialog, fxmlEdit, vertexEdit);
                break;
            case "btnAddVoltmeter":
                image = new Image("/elements/Voltmeter.png");
                ElementView viewVoltmeter = new ElementView(15, 410, 35, image, "");
                Voltmeter voltmeter = new Voltmeter();
                createElement(voltmeter, viewVoltmeter, vertexEditDialog, fxmlEdit, vertexEdit);
                break;
            case "btnAddConnector":
                image = new Image("/elements/dot.png");
                ElementView viewPoint = new ElementView(15, 500, 35, image, "");
                viewPoint.getImageView().setFitHeight(10);
                viewPoint.getImageView().setFitWidth(10);
                Connector connector = new Connector();
                createElement(connector, viewPoint, connectorEditDialog, fxmlCnctrEdit, cnctrEdit);
                break;
            case "btnAddEdge":
                showDialog(edgeEdit,"Connect", fxmlEdgeEdit);
                Edge edge = edgeEditDialog.getEdge();
                if (edge.getFrom() == null || edge.getTo() == null) {
                    //stage.setScene(null);
                    break;
                }
                //edgeEditDialog.setValues(graph, edge);

                double startX = edge.getFrom().getElementView().getImageView().getTranslateX() + 28;
                double startY = edge.getFrom().getElementView().getImageView().getTranslateY();
                double endX = edge.getTo().getElementView().getImageView().getTranslateX();
                double endY = edge.getTo().getElementView().getImageView().getTranslateY() + 28;
                Line line = new Line(startX, startY, endX, endY);
                line.setStrokeWidth(2);
                line.setStroke(Color.BLACK);
                line.setVisible(true);
                anchorPane.getChildren().add(line);
                graph.addEdge(edge);
                edge.setID(graph.edgeSize());
                break;
        }
    }
    private Stage initStage(Stage stage, Parent parent){
        stage = new Stage();
        stage.setTitle("Edit");
        stage.setResizable(false);
        stage.setScene(new Scene(parent));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(mainStage);
        return stage;
    }
    private void showDialog(Stage stage, String title, Parent parent) {
        if (stage == null){
            stage = new Stage();
            stage.setTitle(title);
            stage.setResizable(false);
            stage.setScene(new Scene(parent));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(mainStage);
        }
        stage.showAndWait();

    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    private void createElement(Vertex vertex, ElementView elementView, EditDialog editDialog,
                               Parent parent, Stage stage){
        vertex.setElementView(elementView);
        graph.addVertex(vertex);
        vertex.setID(graph.vertexSize());
        elementView.setTextLabel("(" + graph.vertexSize() + ")");
        anchorPane.getChildren().add(elementView.getImageView());
        anchorPane.getChildren().add(elementView.getLabel());
        elementView.getImageView().setId("btnEdit");
        elementView.getImageView().setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                if (stage == null) {
                    System.out.println("Stage == null");

                }
                editDialog.setValues(graph, vertex);
                stage.showAndWait();
                //showDialog(stage,"Edit", parent);

                System.out.println(vertex.getParameter());
            }
        });
        System.out.println(vertex.getParameter());
        System.out.println(vertex.getID());
    }
}
