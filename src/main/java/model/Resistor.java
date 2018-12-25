package model;

import java.util.LinkedList;
import java.util.List;

public class Resistor extends Vertex {

    private boolean isConnected;
    private String name = "Resistor";

    private boolean isConnected(){
        return isConnected;
    }

    public double getParameter() {
        return 0;
    }

    public void setParameter(double voltage) {

    }

    public void draw() {
        System.out.println(name);
    }
}
