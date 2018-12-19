package controller;

import javafx.fxml.Initializable;
import model.*;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class MainWindow implements Initializable {

    private static Graph graph;

    public void initialize(URL location, ResourceBundle resources) {

    }

    public static void setGraph(Graph graphInit) {
        graph = graphInit;

    }

    public void fillTestGraph(){
        Vertex battery = new Battery(new LinkedList<Vertex>());
        Vertex resistor = new Resistor(new LinkedList<Vertex>());
        Vertex lamp = new Lamp(new LinkedList<Vertex>());
        battery.addAdjacentVertex(resistor);
        battery.setID(0);
        resistor.addAdjacentVertex(lamp);
        resistor.setID(1);
        lamp.addAdjacentVertex(battery);
        lamp.setID(2);
        graph.addVertex(battery);
        graph.addVertex(resistor);
        graph.addVertex(lamp);
        graph.turnOn(lamp);
    }

    
}
