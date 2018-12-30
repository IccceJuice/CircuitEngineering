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
import model.*;

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

    private Parent fxmlEdit;
    private FXMLLoader fxmlLoader = new FXMLLoader();
    private EditDialog editDialog;
    private Stage editDialogStage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image image = new Image("/elements/Battery.png");
        imgBattery.setImage(image);
        image = new Image("/elements/Res.png");
        imgResistor.setImage(image);
        image = new Image("/elements/lampOff.png");
        imgLamp.setImage(image);
        image = new Image("/elements/Ammeter.png");
        imgAmmeter.setImage(image);
        image = new Image("/elements/Voltmeter.png");
        imgVoltmeter.setImage(image);
        try{
            fxmlLoader.setLocation(getClass().getResource("/fxml/EditDialog.fxml"));
            fxmlLoader.setResources(ResourceBundle.getBundle("bundles.Locale", new Locale("en")));
            fxmlEdit = fxmlLoader.load();
            editDialog = fxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setGraph(Graph graphInit) {
        graph = graphInit;

    }


    public void addBattery(MouseDragEvent mouseDragEvent) {

    }
//    public void btnOn(){
//        Vertex battery = new Battery(new LinkedList<Vertex>());
//        Vertex resistor = new Resistor(new LinkedList<Vertex>());
//        Vertex lamp = new Lamp(new LinkedList<Vertex>());
//        battery.addPlusAdjacentVertex(resistor);
//        battery.setID(0);
//        resistor.addPlusAdjacentVertex(lamp);
//        resistor.setID(1);
//        lamp.addPlusAdjacentVertex(null);
//        lamp.setID(2);
//        graph.addVertex(battery);
//        graph.addVertex(resistor);
//        graph.addVertex(lamp);
//        graph.turnOn();
//    }

    public void actionButtonPressed(ActionEvent actionEvent) {

        Object source = actionEvent.getSource();

        if (!(source instanceof Button)) return;

        Button clickedButton = (Button) source;
        String title = "";
        Image image;
        switch (clickedButton.getId()) {
            case "btnAddBattery":
                image = new Image("/elements/Battery.png");
                VertexView viewBattery = new VertexView(47, 80, 20, image, "");
                Battery battery = new Battery();
                battery.setVertexView(viewBattery);
                graph.addVertex(battery);
                battery.setID(graph.size());
                viewBattery.setTextLabel("B (" + graph.size() + ")");
                anchorPane.getChildren().add(viewBattery.getImageView());
                anchorPane.getChildren().add(viewBattery.getLabel());
                viewBattery.getImageView().setId("btnEdit");
                viewBattery.getImageView().setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (event.getClickCount() == 2) {
                            editDialog.setVertex(battery);
                            showDialog("Edit");
                            System.out.println(battery.getParameter());
                        }
                    }
                });
                System.out.println(battery.getParameter());
                System.out.println(battery.getID());
                break;
            case "btnAddResistor":
                image = new Image("/elements/Res.png");
                VertexView viewResistor = new VertexView(15, 170, 35, image, "");
                Resistor resistor = new Resistor();
                resistor.setVertexView(viewResistor);
                graph.addVertex(resistor);
                resistor.setID(graph.size());
                viewResistor.setTextLabel("R (" + graph.size() + ")");
                anchorPane.getChildren().add(viewResistor.getImageView());
                anchorPane.getChildren().add(viewResistor.getLabel());
                viewResistor.getImageView().setId("btnEdit");
                viewResistor.getImageView().setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (event.getClickCount() == 2) {
                            editDialog.setVertex(resistor);
                            showDialog("Edit");
//                            for (int i = 0; i < resistor.getNumberPlusAdjacent().length; ++i){
//                                resistor.addPlusAdjacency(graph.getGraph().get(resistor.getNumberPlusAdjacent()[i]));
//                            }
//                            if (!resistor.getPlusAdjacency().isEmpty()){
//                                Line line = new Line();
//                                for(int i = 0; i < resistor.getPlusAdjacency().size(); ++i){
//                                    line.setStartX(resistor.getVertexView().getImageView().getX());
//                                    line.setStartY(resistor.getVertexView().getImageView().getY());
//                                    line.setEndX(resistor.getPlusAdjacency().get(i).getVertexView().getX());
//                                    line.setEndY(resistor.getPlusAdjacency().get(i).getVertexView().getY());
//                                    line.setVisible(true);
//
//                                }
//                            }
//                            System.out.println(resistor.getParameter());
                        }
                    }
//
                });
                System.out.println(resistor.getParameter());
                System.out.println(resistor.getID());

                break;
            case "btnAddLamp":
                image = new Image("/elements/lampOff.png");
                VertexView viewLamp = new VertexView(16, 260, 42, image, "");
                Lamp lamp = new Lamp();
                lamp.setVertexView(viewLamp);
                graph.addVertex(lamp);
                lamp.setID(graph.size());
                viewLamp.setTextLabel("L (" + graph.size() + ")");
                anchorPane.getChildren().add(viewLamp.getLabel());
                anchorPane.getChildren().add(viewLamp.getImageView());
                viewLamp.getImageView().setId("btnEdit");
                viewLamp.getImageView().setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (event.getClickCount() == 2) {
                            editDialog.setVertex(lamp);
                            showDialog("Edit");
                            System.out.println(lamp.getParameter());
                        }
                    }
                });
                System.out.println(lamp.getParameter());
                System.out.println(lamp.getID());
                break;
            case "btnAddAmmeter":
                image = new Image("/elements/Ammeter.png");
                VertexView viewAmmeter = new VertexView(15, 350, 35, image, "");
                Ammeter ammeter = new Ammeter();
                ammeter.setVertexView(viewAmmeter);
                graph.addVertex(ammeter);
                ammeter.setID(graph.size());
                viewAmmeter.setTextLabel("A (" + graph.size() + ")");
                anchorPane.getChildren().add(viewAmmeter.getImageView());
                anchorPane.getChildren().add(viewAmmeter.getLabel());
                viewAmmeter.getImageView().setId("btnEdit");
                viewAmmeter.getImageView().setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (event.getClickCount() == 2) {
                            editDialog.setVertex(ammeter);
                            showDialog("Edit");
                            System.out.println(ammeter.getParameter());
                        }
                    }
                });
                System.out.println(ammeter.getParameter());
                System.out.println(ammeter.getID());
                break;
            case "btnAddVoltmeter":
                image = new Image("/elements/Voltmeter.png");
                VertexView viewVoltmeter = new VertexView(15, 440, 35, image, "");
                Voltmeter voltmeter = new Voltmeter();
                voltmeter.setVertexView(viewVoltmeter);
                graph.addVertex(voltmeter);
                voltmeter.setID(graph.size());
                viewVoltmeter.setTextLabel("V (" + graph.size() + ")");
                anchorPane.getChildren().add(viewVoltmeter.getImageView());
                anchorPane.getChildren().add(viewVoltmeter.getLabel());
                viewVoltmeter.getImageView().setId("btnEdit");
                viewVoltmeter.getImageView().setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (event.getClickCount() == 2) {
                            editDialog.setVertex(voltmeter);
                            showDialog("Edit");
                            System.out.println(voltmeter.getParameter());
                        }
                    }
                });
                System.out.println(voltmeter.getParameter());
                System.out.println(voltmeter.getID());
                break;

        }
    }
    private void showDialog(String title) {
        if (editDialogStage == null){
            editDialogStage = new Stage();
            editDialogStage.setTitle(title);
            editDialogStage.setMinHeight(320);
            editDialogStage.setMinWidth(300);
            editDialogStage.setResizable(false);
            editDialogStage.setScene(new Scene(fxmlEdit));
            editDialogStage.initModality(Modality.WINDOW_MODAL);
            editDialogStage.initOwner(mainStage);
        }

        editDialogStage.showAndWait();
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

}
