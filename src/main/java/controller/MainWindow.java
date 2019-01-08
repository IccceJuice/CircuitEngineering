package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Edge;
import model.Graph.Graph;
import model.Vertex.*;

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
    private EditDialog editDialog;
    private Stage editDialogStage;

    private Parent fxmlCnctrEdit;
    private ConnectorEditDialog connectorEditDialog;

    private Parent fxmlEdgeEdit;
    private EdgeEditDialog edgeEditDialog;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imgBattery.setImage(new Image("/elements/Battery.png"));
        imgResistor.setImage(new Image("/elements/Res.png"));
        imgLamp.setImage(new Image("/elements/lampOff.png"));
        imgAmmeter.setImage(new Image("/elements/Ammeter.png"));
        imgVoltmeter.setImage(new Image("/elements/Voltmeter.png"));
        imgConnector.setImage(new Image("/elements/dot.png"));
        try{
            fxmlLoader.setLocation(getClass().getResource("/fxml/EditDialog.fxml"));
            fxmlLoader.setResources(ResourceBundle.getBundle("bundles.Locale", new Locale("en")));
            fxmlEdit = fxmlLoader.load();
            editDialog = fxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            fxmlLoaderCnctr.setLocation(getClass().getResource("/fxml/ConnectorEditDialog.fxml"));
            fxmlLoaderCnctr.setResources(ResourceBundle.getBundle("bundles.Locale", new Locale("en")));
            fxmlCnctrEdit = fxmlLoaderCnctr.load();
            connectorEditDialog = fxmlLoaderCnctr.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            fxmlLoaderEdge.setLocation(getClass().getResource("/fxml/EdgeEditDialog.fxml"));
            fxmlLoaderEdge.setResources(ResourceBundle.getBundle("bundles.Locale", new Locale("en")));
            fxmlEdgeEdit = fxmlLoaderEdge.load();
            edgeEditDialog = fxmlLoaderEdge.getController();
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
                battery.setElementView(viewBattery);
                graph.addVertex(battery);
                battery.setID(graph.vertexSize());
                viewBattery.setTextLabel("B (" + graph.vertexSize() + ")");
                anchorPane.getChildren().add(viewBattery.getImageView());
                anchorPane.getChildren().add(viewBattery.getLabel());
                viewBattery.getImageView().setId("btnEdit");
                viewBattery.getImageView().setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (event.getClickCount() == 2) {
                            editDialog.setValues(graph, battery);
                            showDialog("Edit", fxmlEdit);
                            System.out.println(battery.getParameter());
                        }
                    }
                });
                System.out.println(battery.getParameter());
                System.out.println(battery.getID());
                break;
            case "btnAddResistor":
                image = new Image("/elements/Res.png");
                ElementView viewResistor = new ElementView(15, 140, 35, image, "");
                Resistor resistor = new Resistor();
                resistor.setElementView(viewResistor);
                graph.addVertex(resistor);
                resistor.setID(graph.vertexSize());
                viewResistor.setTextLabel("R (" + graph.vertexSize() + ")");
                anchorPane.getChildren().add(viewResistor.getImageView());
                anchorPane.getChildren().add(viewResistor.getLabel());
                viewResistor.getImageView().setId("btnEdit");
                viewResistor.getImageView().setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (event.getClickCount() == 2) {
                            editDialog.setValues(graph, resistor);
                            showDialog("Edit", fxmlEdit);
                        }
                    }
                });
                System.out.println(resistor.getParameter());
                System.out.println(resistor.getID());

                break;
            case "btnAddLamp":
                image = new Image("/elements/lampOff.png");
                ElementView viewLamp = new ElementView(16, 230, 42, image, "");
                Lamp lamp = new Lamp();
                lamp.setElementView(viewLamp);
                graph.addVertex(lamp);
                lamp.setID(graph.vertexSize());
                viewLamp.setTextLabel("L (" + graph.vertexSize() + ")");
                anchorPane.getChildren().add(viewLamp.getLabel());
                anchorPane.getChildren().add(viewLamp.getImageView());
                viewLamp.getImageView().setId("btnEdit");
                viewLamp.getImageView().setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (event.getClickCount() == 2) {
                            editDialog.setValues(graph, lamp);
                            showDialog("Edit", fxmlEdit);
                            System.out.println(lamp.getParameter());
                        }
                    }
                });
                System.out.println(lamp.getParameter());
                System.out.println(lamp.getID());
                break;
            case "btnAddAmmeter":
                image = new Image("/elements/Ammeter.png");
                ElementView viewAmmeter = new ElementView(15, 320, 35, image, "");
                Ammeter ammeter = new Ammeter();
                ammeter.setElementView(viewAmmeter);
                graph.addVertex(ammeter);
                ammeter.setID(graph.vertexSize());
                viewAmmeter.setTextLabel("A (" + graph.vertexSize() + ")");
                anchorPane.getChildren().add(viewAmmeter.getImageView());
                anchorPane.getChildren().add(viewAmmeter.getLabel());
                viewAmmeter.getImageView().setId("btnEdit");
                viewAmmeter.getImageView().setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (event.getClickCount() == 2) {
                            editDialog.setValues(graph, ammeter);
                            showDialog("Edit", fxmlEdit);
                            System.out.println(ammeter.getParameter());
                        }
                    }
                });
                System.out.println(ammeter.getParameter());
                System.out.println(ammeter.getID());
                break;
            case "btnAddVoltmeter":
                image = new Image("/elements/Voltmeter.png");
                ElementView viewVoltmeter = new ElementView(15, 410, 35, image, "");
                Voltmeter voltmeter = new Voltmeter();
                voltmeter.setElementView(viewVoltmeter);
                graph.addVertex(voltmeter);
                voltmeter.setID(graph.vertexSize());
                viewVoltmeter.setTextLabel("V (" + graph.vertexSize() + ")");
                anchorPane.getChildren().add(viewVoltmeter.getImageView());
                anchorPane.getChildren().add(viewVoltmeter.getLabel());
                viewVoltmeter.getImageView().setId("btnEdit");
                viewVoltmeter.getImageView().setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (event.getClickCount() == 2) {
                            editDialog.setValues(graph, voltmeter);
                            showDialog("Edit", fxmlEdit);
                            System.out.println(voltmeter.getParameter());
                        }
                    }
                });
                System.out.println(voltmeter.getParameter());
                System.out.println(voltmeter.getID());
                break;
            case "btnAddConnector":
                image = new Image("/elements/dot.png");
                ElementView viewPoint = new ElementView(15, 500, 35, image, "");
                viewPoint.getImageView().setFitHeight(10);
                viewPoint.getImageView().setFitWidth(10);
                Connector connector = new Connector();
                connector.setElementView(viewPoint);
                graph.addVertex(connector);
                connector.setID(graph.vertexSize());
                viewPoint.setTextLabel("C (" + graph.vertexSize() + ")");
                anchorPane.getChildren().add(viewPoint.getImageView());
                anchorPane.getChildren().add(viewPoint.getLabel());
                viewPoint.getImageView().setId("btnEdit");
                viewPoint.getImageView().setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (event.getClickCount() == 2) {
                            connectorEditDialog.setValues(graph, connector);
                            showDialog("Edit", fxmlCnctrEdit);
                            System.out.println(connector.getParameter());
                        }
                    }
                });
                System.out.println(connector.getParameter());
                System.out.println(connector.getID());
                break;
            case "btnAddEdge":
                image = new Image("/elements/dot.png");
                ElementView viewLine = new ElementView(15, 500, 35, image, "");
                viewLine.getImageView().setFitHeight(10);
                viewLine.getImageView().setFitWidth(10);
                Edge edge = new Edge();
                edge.setElementView(viewLine);
                graph.addEdge(edge);
                edge.setID(graph.edgeSize());
                viewLine.setTextLabel("L (" + graph.edgeSize() + ")");
                anchorPane.getChildren().add(viewLine.getImageView());
                anchorPane.getChildren().add(viewLine.getLabel());
                viewLine.getImageView().setId("btnEdit");
                viewLine.getImageView().setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (event.getClickCount() == 2) {
                            edgeEditDialog.setValues(graph, edge);
                            showDialog("Edit", fxmlEdgeEdit);
                        }
                    }
                });
                break;
        }
    }
    private void showDialog(String title, Parent parent) {
        if (editDialogStage == null){
            editDialogStage = new Stage();
            editDialogStage.setTitle(title);
            editDialogStage.setResizable(false);
            editDialogStage.setScene(new Scene(parent));
            editDialogStage.initModality(Modality.WINDOW_MODAL);
            editDialogStage.initOwner(mainStage);
        }
        editDialogStage.showAndWait();
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }
}
