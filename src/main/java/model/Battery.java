package model;

import java.util.LinkedList;

public class Battery extends Vertex {

    private double voltage = 0;
    private String name = "Battery";
    private LinkedList<Vertex> vertexList;
    private boolean isConnected = false;


    public Battery(LinkedList<Vertex> vertexList){
        this.vertexList = vertexList;
    }

    private boolean isConnected(){
        return isConnected;
    }

    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public void draw() {
        System.out.println(name);
    }
}
