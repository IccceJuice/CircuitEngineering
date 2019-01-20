package model.Vertex;



public class Battery extends Vertex {

    private double voltage = 12;
    private String name = "Battery";
    private boolean isConnected = false;



    private boolean isConnected(){
        return isConnected;
    }

    public double getParameter() {
        return voltage;
    }

    public void setParameter(double voltage) {
        this.voltage = voltage;
    }

    @Override
    public String getName() {
        return name;
    }

    public void draw() {
        System.out.println(name);
    }

    @Override
    public Vertex getTop() {
        return null;
    }

    @Override
    public Vertex getBottom() {
        return null;
    }

    @Override
    public void turnOnElement() {

    }

    @Override
    public void turnOffElement() {

    }

}
