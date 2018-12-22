package model;


import controller.ViewBattery;

public class Battery extends Vertex {

    private double voltage = 12;
    private String name = "Battery";
    private boolean isConnected = false;
    private ViewBattery viewBattery;


    public void setViewBattery(ViewBattery viewBattery) {
        this.viewBattery = viewBattery;
    }

    private boolean isConnected(){
        return isConnected;
    }

    public double getParameter() {
        return voltage;
    }

    public void setParameter(double voltage) {
        this.voltage = voltage;
    }

    public void draw() {
        System.out.println(name);
    }

    public ViewBattery getViewBattery() {
        return viewBattery;
    }
}
