package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
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

    @FXML
    private ToggleButton btnOnAction;
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
    private FXMLLoader fxmlLoaderDeleteEdge = new FXMLLoader();

    private Parent fxmlEdit;
    private VertexEditDialog vertexEditDialog;
    private Stage vertexEdit;

    private Parent fxmlDeleteEdge;
    private EdgeEditDialog deleteEdgeDialog;
    private Stage deleteEdge;

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

        fxmlLoaderDeleteEdge.setLocation(getClass().getResource("/fxml/DeleteEdge.fxml"));
        try {
            fxmlDeleteEdge = fxmlLoaderDeleteEdge.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        deleteEdgeDialog = fxmlLoaderDeleteEdge.getController();

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
        deleteEdge = initStage(deleteEdge, fxmlDeleteEdge);
    }

//    private void initEditDialog( Parent parent){
//        FXMLLoader fxmlLoader = new FXMLLoader();
//        fxmlLoader.setLocation(getClass().getResource("/fxml/EditDialog.fxml"));
//        fxmlLoader.setResources(ResourceBundle.getBundle("bundles.Locale", new Locale("en")));
//        parent = null;
//        try {
//            parent = fxmlLoader.load();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

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
                viewBattery.setRotate(ElementView.Rotate.vertical);
                Battery battery = new Battery();
                createElement( battery, viewBattery, vertexEditDialog, vertexEdit);
                graph.setBatteryID(battery.getID() - 1);
                graph.setBatteryConnected(true);
                break;
            case "btnAddResistor":
                image = new Image("/elements/Res.png");
                ElementView viewResistor = new ElementView(15, 140, 35, image, "");
                viewResistor.setRotate(ElementView.Rotate.horizontal);
                Resistor resistor = new Resistor();
                createElement(resistor, viewResistor, vertexEditDialog, vertexEdit);
                break;
            case "btnAddLamp":
                image = new Image("/elements/lampOff.png");
                ElementView viewLamp = new ElementView(16, 230, 42, image, "");
                viewLamp.setRotate(ElementView.Rotate.horizontal);
                Lamp lamp = new Lamp();
                createElement(lamp, viewLamp, vertexEditDialog, vertexEdit);
                break;
            case "btnAddAmmeter":
                image = new Image("/elements/Ammeter.png");
                ElementView viewAmmeter = new ElementView(15, 320, 35, image, "");
                viewAmmeter.setRotate(ElementView.Rotate.horizontal);
                Ammeter ammeter = new Ammeter();
                createElement(ammeter, viewAmmeter, vertexEditDialog, vertexEdit);
                break;
            case "btnAddVoltmeter":
                image = new Image("/elements/Voltmeter.png");
                ElementView viewVoltmeter = new ElementView(15, 410, 35, image, "");
                viewVoltmeter.setRotate(ElementView.Rotate.horizontal);
                Voltmeter voltmeter = new Voltmeter();
                createElement(voltmeter, viewVoltmeter, vertexEditDialog, vertexEdit);
                break;
            case "btnAddConnector":
                image = new Image("/elements/dot.png");
                ElementView viewPoint = new ElementView(15, 500, 35, image, "");
                viewPoint.setRotate(ElementView.Rotate.horizontal);
                viewPoint.getImageView().setFitHeight(10);
                viewPoint.getImageView().setFitWidth(10);
                Connector connector = new Connector();
                createElement(connector, viewPoint, connectorEditDialog, cnctrEdit);
                break;
            case "btnAddEdge":
                Edge edge = new Edge();
                edgeEditDialog.setValues(graph, edge, anchorPane);
                showDialog(edgeEdit,"Connect", fxmlEdgeEdit);
                if (edge.getFrom() == null || edge.getTo() == null) {
                    break;
                }
                edge.getFrom().addAdjacentEdge(edge);
                edge.getTo().addAdjacentEdge(edge);

                //todo Отрисовка линий
                edge.setEdgeView(new EdgeView(edge.getFrom().getElementView(), edge.getTo().getElementView()));
                edge.getFrom().getElementView().addAdjacentLine(edge.getEdgeView());
                edge.getTo().getElementView().addAdjacentLine(edge.getEdgeView());
                anchorPane.getChildren().add(edge.getEdgeView().getLine());
                graph.addEdge(edge);
                edge.setID(graph.edgeSize());
                edge.getEdgeView().getLine().setOnMouseClicked(event -> {
                    if (event.getClickCount() == 2) {
                        deleteEdgeDialog.setValues(graph, edge, anchorPane);
                        deleteEdge.showAndWait();
//                        System.out.println(vertex.getParameter());
                    }
                });
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

    private void createElement(Vertex vertex, ElementView elementView, EditDialog editDialog, Stage stage){
        vertex.setElementView(elementView);
        graph.addVertex(vertex);
        vertex.setID(graph.vertexSize());
        elementView.setTextLabel("(" + graph.vertexSize() + ")");
        anchorPane.getChildren().add(elementView.getImageView());
        anchorPane.getChildren().add(elementView.getLabel());
        elementView.getImageView().setId("btnEdit");
        elementView.getImageView().setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                editDialog.setValues(graph, vertex, anchorPane, vertex.getElementView().getLabel());
                stage.showAndWait();
                System.out.println(vertex.getParameter());
            }
        });
        System.out.println(vertex.getParameter());
        System.out.println(vertex.getID());
    }

    public void btnOnAction(ActionEvent actionEvent) {
        if (btnOnAction.getText().equals("On")) {
            graph.printCycles();
            btnOnAction.setText("Off");
        }
        else{
            graph.turnOffGraph();
            btnOnAction.setText("On");
        }
    }

    public void clearAll(ActionEvent actionEvent) {
        graph.getVertices().clear();
        graph.getEdges().clear();
        anchorPane.getChildren().clear();
    }

//    protected static void deleteVertex(Vertex vertex){
//        anchorPane
//        graph.getVertices().remove(vertex.getID() - 1);
//    }
}
