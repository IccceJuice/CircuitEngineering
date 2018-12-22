package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.AnchorPane;
import model.*;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class MainWindow implements Initializable {



    private Map<Vertex, Label> modelView;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image image = new Image("/elements/Bat2.png");
        imgBattery.setImage(image);
         image = new Image("/elements/Res.png");
        imgResistor.setImage(image);
        image = new Image("/elements/lampOff.png");
        imgLamp.setImage(image);
        image = new Image("/elements/Ammeter.png");
        imgAmmeter.setImage(image);
        image = new Image("/elements/Voltmeter.png");
        imgVoltmeter.setImage(image);
    }

    public static void setGraph(Graph graphInit) {
        graph = graphInit;

    }

    public void fillTestGraph(){

    }


    public void clearAll(ActionEvent actionEvent) {
    }

    public void on(ActionEvent actionEvent) {


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

    public void btnOff(){

    }

    public void actionButtonPressed(ActionEvent actionEvent) {

        Object source = actionEvent.getSource();

        if (!(source instanceof Button)) return;

        Button clickedButton = (Button) source;
        //Vertex selectedTrack = (UITrack)tableSongsLibrary.getSelectionModel().getSelectedItem();
        String title = "";
        switch (clickedButton.getId()) {
            case "btnAddBattery":
                Image image = new Image("/elements/Bat2.png");
                ViewVertex viewVertex = new ViewBattery(image);
                anchorPane.getChildren().addAll(viewVertex.getImageView());

//                title = resourceBundle.getString("add");
//                editDialogController.setTrack(new UITrack(), true);
//                showDialog(title);
//                if(editDialogController.getTrack() != null){
//                    trackList.getTracks().add(editDialogController.getTrack());
//                }
//                tableSongsLibrary.refresh();
//
                break;
//            case "btnEdit":
//                if (!trackIsSelected(selectedTrack)) {
//                    return;
//                }
//                title = resourceBundle.getString("edit");
//                editDialogController.setTrack(selectedTrack, false);
//                showDialog(title);
//                tableSongsLibrary.refresh();
//
//                break;
//            case "btnSelectDel":
//                if (!trackIsSelected(selectedTrack)) {
//                    return;
//                }
//                title = resourceBundle.getString("delete");
//                trackList.delete(selectedTrack);
//                tableSongsLibrary.refresh();
//                break;
//        }
//        Vertex battery = new Battery(new LinkedList<Vertex>());
//        graph.addVertex(battery);
//        int ID = graph.getGraph().indexOf(battery);
//        battery.setID(ID);
//        System.out.println(ID);
//        btnBattery.setOnMousePressed(e -> {
//            battery.setX(btnBattery.getTranslateX() - e.getSceneX());
//            battery.setY(btnBattery.getTranslateY() - e.getSceneY());
//        });
//        btnBattery.setOnMouseDragged(e -> {
//            btnBattery.setTranslateX(battery.getX() + e.getSceneX());
//            btnBattery.setTranslateY(battery.getY() + e.getSceneY());
//        });
        }
//    public void btnAddBattery(MouseDragEvent mouseDragEvent) {
//
//    }

    }
}
