package model;

import java.util.LinkedList;

public class Battery extends Vertex {

    private double voltage = 12;
    private String name = "Battery";
    private boolean isConnected = false;



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
